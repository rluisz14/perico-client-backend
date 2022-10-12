package pe.perico.client.backend.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.perico.client.backend.controller.web.dto.OrderRequestWebDto;
import pe.perico.client.backend.controller.web.dto.OrderResponseWebDto;
import pe.perico.client.backend.db.OrderRepository;
import pe.perico.client.backend.mapper.OrderMapper;

@Slf4j
@AllArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public OrderResponseWebDto registerOrder(OrderRequestWebDto orderRequestWebDto) {
        OrderResponseWebDto orderResponseWebDto = new OrderResponseWebDto();
        orderResponseWebDto.setOrderId(orderRepository.
                registerOrder(orderMapper.convertOrderRequestWebDtoToOrder(orderRequestWebDto)));
        return orderResponseWebDto;
    }
}
