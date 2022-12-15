package pe.perico.client.backend.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.HttpClientErrorException;
import pe.perico.client.backend.constants.Constants;
import pe.perico.client.backend.controller.web.dto.*;
import pe.perico.client.backend.db.*;
import pe.perico.client.backend.domain.*;
import pe.perico.client.backend.mapper.OrderDetailMapper;
import pe.perico.client.backend.mapper.OrderMapper;
import pe.perico.client.backend.util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final UserRepository userRepository;
    private final PriceDetailsService priceDetailsService;
    private final ProductDetailRepository productDetailRepository;
    private final SupplyRepository supplyRepository;
    private final OrderMapper orderMapper;
    private final OrderDetailMapper orderDetailMapper;

    @Override
    public OrderResponseWebDto registerOrder(OrderRequestWebDto orderRequestWebDto) {
        PriceDetailsRequestWebDto priceDetailsRequestWebDto = new PriceDetailsRequestWebDto();
        priceDetailsRequestWebDto.setProducts(orderRequestWebDto.getProducts());
        PriceDetailsResponseWebDto priceDetailsResponseWebDto = priceDetailsService.getPriceDetails(priceDetailsRequestWebDto);

        Optional<User> employeeDefault =  userRepository.findUserByType(Constants.EMPLOYEE_TYPE_USER);
        if (employeeDefault.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, Constants.EMPLOYEE_NOT_EXISTS);
        }

        Optional<User> client =  userRepository.findUserByPersonDocument(orderRequestWebDto.getClientDocumentNumber());
        if (client.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED, Constants.CLIENT_NOT_EXISTS);
        }

        List<ProductOrderRequestWebDto> productsFiltered = setQuantityForEachProduct(orderRequestWebDto.getProducts());
        List<SupplyStock> suppliesFiltered = setQuantityForEachSupply(productsFiltered);

        suppliesFiltered.forEach(supplyFiltered -> {
                Optional<Supply> supplyOptional = supplyRepository.findSupplyBySupplyId(supplyFiltered.getSupplyId());

                if (supplyOptional.isEmpty()) {
                    throw new HttpClientErrorException(HttpStatus.NOT_FOUND, Constants.SUPPLY_NOT_EXISTS);
                }

                if (supplyOptional.get().getSupplyStock() < supplyFiltered.getQuantityUsed()) {
                    throw new HttpClientErrorException(HttpStatus.PRECONDITION_FAILED, Constants.SUPPLY_NOT_AVAILABLE);
                }
        });

        OrderResponseWebDto orderResponseWebDto = new OrderResponseWebDto();
        orderResponseWebDto.setOrderId(orderRepository.registerOrder(orderMapper.convertOrderRequestWebDtoToOrder(orderRequestWebDto,
                priceDetailsResponseWebDto.getPriceDetails(), employeeDefault.get().getUserId(), client.get().getUserId())));

        productsFiltered.forEach(product -> {
            orderDetailRepository.registerOrderDetail(orderDetailMapper.convertOrderRequestWebDtoToOrder(product,
                    Long.valueOf(orderResponseWebDto.getOrderId())));
        });

        suppliesFiltered.forEach(suppliesForUpdateStock -> {
            Optional<Supply> supplyOptional = supplyRepository.findSupplyBySupplyId(suppliesForUpdateStock.getSupplyId());
            Double newSupplyStock = supplyOptional.get().getSupplyStock() - suppliesForUpdateStock.getQuantityUsed();
            supplyRepository.updateSupplyStock(suppliesForUpdateStock.getSupplyId(), newSupplyStock);
        });

        return orderResponseWebDto;
    }

    @Override
    public ListOrderResponseWebDto findAllOrders(List<String> orderStatus) {
        ListOrderResponseWebDto listOrderResponseWebDto = new ListOrderResponseWebDto();
        listOrderResponseWebDto.setOrders(new ArrayList<>());
        List<OrderView> orders = orderRepository.findAllOrders(orderStatus);
        orders.forEach(order -> {
            List<OrderDetailView> orderDetailViews = orderDetailRepository.findOrderDetailByOrderId(order.getOrderId());
            listOrderResponseWebDto.getOrders().add(orderMapper.convertOrderViewToOrderViewComplete(order, orderDetailViews));
        });

        return listOrderResponseWebDto;
    }

    private List<ProductOrderRequestWebDto> setQuantityForEachProduct(List<ProductOrderRequestWebDto> products) {
        List<ProductOrderRequestWebDto> productDistinctList = products.stream()
                .filter(Util.distinctByKey(ProductOrderRequestWebDto::getProductId))
                .collect(Collectors.toList());


        for (ProductOrderRequestWebDto productDistinct : productDistinctList) {
            int quantity = 1;
            for (ProductOrderRequestWebDto product : products) {
                if (productDistinct.getProductId().equals(product.getProductId())) {
                    productDistinct.setQuantity(quantity);
                    quantity++;
                }
            }
        }

        return productDistinctList;
    }

    private List<SupplyStock> setQuantityForEachSupply(List<ProductOrderRequestWebDto> products) {
        List<SupplyStock> supplies = new ArrayList<>();

        products.forEach(product -> {
            List<ProductDetail> productDetails = productDetailRepository.findProductDetailByByProductId(product.getProductId());
            if (CollectionUtils.isEmpty(productDetails)) {
                throw new HttpClientErrorException(HttpStatus.PRECONDITION_FAILED, Constants.SUPPLY_NOT_AVAILABLE);
            }
            productDetails.forEach(productDetail -> {
                SupplyStock supply = SupplyStock.builder()
                        .supplyId(productDetail.getSupplyId())
                        .quantityUsed(productDetail.getQuantity() * product.getQuantity())
                        .build();
                supplies.add(supply);
            });

        });

       List<SupplyStock> suppliesDistinctList = supplies.stream()
                .filter(Util.distinctByKey(SupplyStock::getSupplyId))
                .collect(Collectors.toList());

        List<SupplyStock> suppliesWithQuantity = new ArrayList<>();

        for (SupplyStock supplyDistinctList : suppliesDistinctList) {
           Double quantity =  supplyDistinctList.getQuantityUsed();
           int count = 0;
            for (SupplyStock supplyStock : supplies) {
                if (supplyDistinctList.getSupplyId().equals(supplyStock.getSupplyId())) {
                    if (count == 0) {
                        quantity =  supplyStock.getQuantityUsed();
                        count++;
                    } else {
                        quantity =  quantity + supplyStock.getQuantityUsed();
                        count++;
                    }
                }
            }

            SupplyStock stock = SupplyStock.builder()
                    .supplyId(supplyDistinctList.getSupplyId())
                    .quantityUsed(quantity)
                    .build();
            suppliesWithQuantity.add(stock);
        }

        return suppliesWithQuantity;
    }
}
