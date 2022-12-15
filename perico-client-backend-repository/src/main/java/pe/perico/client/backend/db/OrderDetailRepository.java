package pe.perico.client.backend.db;

import pe.perico.client.backend.domain.OrderDetail;
import pe.perico.client.backend.domain.OrderDetailView;

import java.util.List;

/**
 * @author rluisz14  on 08/10/2022
 */
public interface OrderDetailRepository {

    String registerOrderDetail(OrderDetail orderDetail);
    List<OrderDetailView> findOrderDetailByOrderId(Long orderId);
}
