package pe.perico.client.backend.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.perico.client.backend.controller.web.dto.*;
import pe.perico.client.backend.db.OrderDetailRepository;
import pe.perico.client.backend.db.OrderRepository;
import pe.perico.client.backend.mapper.OrderDetailMapper;
import pe.perico.client.backend.mapper.OrderMapper;
import pe.perico.client.backend.util.StreamUtil;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final PriceDetailsService priceDetailsService;
    private final OrderMapper orderMapper;
    private final OrderDetailMapper orderDetailMapper;

    @Override
    public OrderResponseWebDto registerOrder(OrderRequestWebDto orderRequestWebDto) {
        PriceDetailsRequestWebDto priceDetailsRequestWebDto = new PriceDetailsRequestWebDto();
        priceDetailsRequestWebDto.setProducts(orderRequestWebDto.getProducts());
        PriceDetailsResponseWebDto priceDetailsResponseWebDto = priceDetailsService.getPriceDetails(priceDetailsRequestWebDto);

        OrderResponseWebDto orderResponseWebDto = new OrderResponseWebDto();
        orderResponseWebDto.setOrderId(orderRepository.registerOrder(orderMapper
                .convertOrderRequestWebDtoToOrder(orderRequestWebDto, priceDetailsResponseWebDto.getPriceDetails())));

        List<ProductOrderRequestWebDto> productsFiltered = setQuantityForEachProduct(orderRequestWebDto.getProducts());
        productsFiltered.stream().forEach(product -> {
            orderDetailRepository.registerOrderDetail(orderDetailMapper.convertOrderRequestWebDtoToOrder(product,
                    Long.valueOf(orderResponseWebDto.getOrderId())));
        });

        return orderResponseWebDto;
    }

    private List<ProductOrderRequestWebDto> setQuantityForEachProduct(List<ProductOrderRequestWebDto> products) {
        List<ProductOrderRequestWebDto> productDistinctList = products.stream()
                .filter(StreamUtil.distinctByKey(ProductOrderRequestWebDto::getProductId))
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
