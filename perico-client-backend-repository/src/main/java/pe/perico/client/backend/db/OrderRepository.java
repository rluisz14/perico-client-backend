package pe.perico.client.backend.db;

import pe.perico.client.backend.domain.Order;

import java.util.List;

/**
 * @author rluisz14  on 08/10/2022
 */
public interface OrderRepository {

    List<Order> findAllOrders();
    String registerOrder(Order order);
    String updateOrder(Order order);
    String deleteOrder(Long orderId);
}
