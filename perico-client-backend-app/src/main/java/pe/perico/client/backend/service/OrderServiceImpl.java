package pe.perico.client.backend.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.perico.client.backend.controller.web.dto.OrderRequestWebDto;
import pe.perico.client.backend.controller.web.dto.OrderResponseWebDto;
import pe.perico.client.backend.db.OrderRepository;
import pe.perico.client.backend.domain.Order;

@Slf4j
@AllArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public OrderResponseWebDto registerOrder(OrderRequestWebDto orderRequestWebDto) {
        OrderResponseWebDto orderResponseWebDto = new OrderResponseWebDto();
        orderResponseWebDto.setOrderId(orderRepository.registerOrder(new Order(null,1L,1L,null,null,"")));
        return orderResponseWebDto;
    }
}
