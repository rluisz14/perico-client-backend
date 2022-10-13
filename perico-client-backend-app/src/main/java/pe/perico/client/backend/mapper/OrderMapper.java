package pe.perico.client.backend.mapper;

import org.springframework.stereotype.Component;
import pe.perico.client.backend.constants.Constants;
import pe.perico.client.backend.controller.web.dto.OrderRequestWebDto;
import pe.perico.client.backend.domain.Order;
import pe.perico.client.backend.domain.OrderStatus;
import pe.perico.client.backend.domain.PriceDetails;

import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * @author rluisz14  on 08/10/2022
 */
@Component
public class OrderMapper {

    public Order convertOrderRequestWebDtoToOrder(OrderRequestWebDto orderRequestWebDto, PriceDetails priceDetails) {
        return Order.builder()
                .employeeUserId(orderRequestWebDto.getEmployeeUserId())
                .clientUserId(orderRequestWebDto.getClientUserId())
                .orderDate(LocalDateTime.now(ZoneId.of(Constants.ZONE_AMERICA)))
                .orderStatus(OrderStatus.TO_BE_DELIVERED.getDescription())
                .subtotal(priceDetails.getSubTotal())
                .igv(priceDetails.getIgv())
                .deliveryCost(priceDetails.getDeliveryCost())
                .total(priceDetails.getTotal())
                .build();
    }
}
