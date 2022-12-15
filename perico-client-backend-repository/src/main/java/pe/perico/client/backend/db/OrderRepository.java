package pe.perico.client.backend.db;

import pe.perico.client.backend.domain.Order;
import pe.perico.client.backend.domain.OrderView;

import java.util.List;

/**
 * @author rluisz14  on 08/10/2022
 */
public interface OrderRepository {

    List<OrderView> findAllOrders(List<String> orderStatus);
    String registerOrder(Order order);
    String updateOrder(Order order);
    String deleteOrder(Long orderId);
}
