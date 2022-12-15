package pe.perico.client.backend.service;

import pe.perico.client.backend.controller.web.dto.ListOrderResponseWebDto;
import pe.perico.client.backend.controller.web.dto.OrderRequestWebDto;
import pe.perico.client.backend.controller.web.dto.OrderResponseWebDto;

import java.util.List;

/**
 * @author rluisz14  on 08/10/2022
 */
public interface OrderService {

    OrderResponseWebDto registerOrder(OrderRequestWebDto orderRequestWebDto);
    ListOrderResponseWebDto findAllOrders(List<String> orderStatus);

    
}
