package pe.perico.client.backend.mapper;

import org.springframework.stereotype.Component;
import pe.perico.client.backend.constants.Constants;
import pe.perico.client.backend.controller.web.dto.OrderRequestWebDto;
import pe.perico.client.backend.domain.Order;
import pe.perico.client.backend.domain.OrderStatus;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author rluisz14  on 08/10/2022
 */
@Component
public class OrderMapper {

    public Order convertOrderRequestWebDtoToOrder(OrderRequestWebDto orderRequestWebDto){
        return Order.builder()
                .employeeUserId(orderRequestWebDto.getEmployeeUserId())
                .clientUserId(orderRequestWebDto.getClientUserId())
                .orderDate(ZonedDateTime.now(ZoneId.of(Constants.ZONE_AMERICA)))
                .orderDeliveredDate(orderRequestWebDto.getOrderDeliveredDate())
                .orderStatus(OrderStatus.IN_PROGRESS.getDescription())
                .build();
    }
}
