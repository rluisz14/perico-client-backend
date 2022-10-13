package pe.perico.client.backend.mapper;

import org.springframework.stereotype.Component;
import pe.perico.client.backend.controller.web.dto.ProductOrderRequestWebDto;
import pe.perico.client.backend.domain.OrderDetail;

/**
 * @author rluisz14  on 08/10/2022
 */
@Component
public class OrderDetailMapper {

    public OrderDetail convertOrderRequestWebDtoToOrder(ProductOrderRequestWebDto productOrderRequestWebDto, Long orderId) {
        return OrderDetail.builder()
                .orderId(orderId)
                .productId(productOrderRequestWebDto.getProductId())
                .price(productOrderRequestWebDto.getProductPrice())
                .quantity(productOrderRequestWebDto.getQuantity())
                .build();
    }
}
