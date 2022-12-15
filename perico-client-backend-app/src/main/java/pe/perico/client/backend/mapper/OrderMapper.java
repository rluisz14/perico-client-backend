package pe.perico.client.backend.mapper;

import org.springframework.stereotype.Component;
import pe.perico.client.backend.constants.Constants;
import pe.perico.client.backend.controller.web.dto.OrderRequestWebDto;
import pe.perico.client.backend.domain.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Objects;

/**
 * @author rluisz14  on 08/10/2022
 */
@Component
public class OrderMapper {

    public Order convertOrderRequestWebDtoToOrder(OrderRequestWebDto orderRequestWebDto, PriceDetails priceDetails, Long employeeIdDefault, Long clientUserId) {
        return Order.builder()
                .employeeUserId(Objects.nonNull(orderRequestWebDto.getEmployeeUserId()) ? orderRequestWebDto.getEmployeeUserId() : employeeIdDefault)
                .clientUserId(Objects.nonNull(orderRequestWebDto.getClientUserId()) ? orderRequestWebDto.getClientUserId() : clientUserId)
                .orderDate(LocalDateTime.now(ZoneId.of(Constants.ZONE_AMERICA)))
                .orderStatus(OrderStatus.NEW.getDescription())
                .subtotal(priceDetails.getSubTotal())
                .igv(priceDetails.getIgv())
                .deliveryCost(priceDetails.getDeliveryCost())
                .total(priceDetails.getTotal())
                .phoneNumber(orderRequestWebDto.getPhoneNumber())
                .email(orderRequestWebDto.getEmail())
                .paymentMethod(orderRequestWebDto.getPaymentMethod())
                .addressDelivery(orderRequestWebDto.getAddressDelivery())
                .addressReferenceDelivery(orderRequestWebDto.getAddressReferenceDelivery())
                .build();
    }

    public OrderViewComplete convertOrderViewToOrderViewComplete(OrderView orderView, List<OrderDetailView> orderDetailViews) {
        return OrderViewComplete.builder()
                .orderId(orderView.getOrderId())
                .clientDocumentNumber(orderView.getClientDocumentNumber())
                .clientName(orderView.getClientName())
                .employeeName(orderView.getEmployeeName())
                .orderDate(orderView.getOrderDate())
                .orderDeliveredDate(orderView.getOrderDeliveredDate())
                .orderStatus(orderView.getOrderStatus())
                .subtotal(orderView.getSubtotal())
                .igv(orderView.getIgv())
                .deliveryCost(orderView.getDeliveryCost())
                .total(orderView.getTotal())
                .phoneNumber(orderView.getPhoneNumber())
                .email(orderView.getEmail())
                .paymentMethod(orderView.getPaymentMethod())
                .addressDelivery(orderView.getAddressDelivery())
                .addressReferenceDelivery(orderView.getAddressReferenceDelivery())
                .details(orderDetailViews)
                .build();
    }
}
