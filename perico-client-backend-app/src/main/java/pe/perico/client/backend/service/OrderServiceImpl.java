package pe.perico.client.backend.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import pe.perico.client.backend.constants.Constants;
import pe.perico.client.backend.controller.web.dto.*;
import pe.perico.client.backend.db.OrderDetailRepository;
import pe.perico.client.backend.db.OrderRepository;
import pe.perico.client.backend.db.UserRepository;
import pe.perico.client.backend.domain.User;
import pe.perico.client.backend.mapper.OrderDetailMapper;
import pe.perico.client.backend.mapper.OrderMapper;
import pe.perico.client.backend.util.Util;

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

        OrderResponseWebDto orderResponseWebDto = new OrderResponseWebDto();
        orderResponseWebDto.setOrderId(orderRepository.registerOrder(orderMapper.convertOrderRequestWebDtoToOrder(orderRequestWebDto,
                priceDetailsResponseWebDto.getPriceDetails(), employeeDefault.get().getUserId(), client.get().getUserId())));

        List<ProductOrderRequestWebDto> productsFiltered = setQuantityForEachProduct(orderRequestWebDto.getProducts());
        productsFiltered.stream().forEach(product -> {
            orderDetailRepository.registerOrderDetail(orderDetailMapper.convertOrderRequestWebDtoToOrder(product,
                    Long.valueOf(orderResponseWebDto.getOrderId())));
        });

        return orderResponseWebDto;
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
}
