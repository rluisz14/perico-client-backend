package pe.perico.client.backend.db;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import pe.perico.client.backend.db.rowmapper.OrderRowMapper;
import pe.perico.client.backend.domain.Order;
import pe.perico.client.backend.domain.OrderView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author rluisz14  on 08/10/2022
 */

@Slf4j
@Repository
@AllArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {

    private final JdbcTemplate jdbcTemplate;
    private final OrderRowMapper orderRowMapper;

    private static final String TBL_ORDER = "[Order]";
    private static final String SCHEMA_BUSINESS = "[Business]";
    private static final String FIND_ORDER_BY_STATUS_TWO = "SELECT o.orderId,pc.personDocument AS clientDocumentNumber, pc.personName AS clientName,\n" +
                                                        "pe.personName AS employeeName,\n" +
                                                        "o.orderDate, o.orderDeliveredDate, o.orderStatus,\n" +
                                                        "o.subtotal, o.igv, o.deliveryCost, o.total, o.phoneNumber, o.email, o.paymentMethod,\n" +
                                                        "o.addressDelivery, o.addressReferenceDelivery\n" +
                                                        "FROM [Business].[Order] o \n" +
                                                        "INNER JOIN [Business].[Person] pc ON o.clientUserId = pc.personId\n" +
                                                        "INNER JOIN [Business].[Person] pe ON o.employeeUserId = pe.personId\n" +
                                                        "WHERE [orderStatus] = ? OR [orderStatus] = ? ORDER BY orderDate DESC";
    private static final String FIND_ORDER_BY_STATUS = "SELECT o.orderId,pc.personDocument AS clientDocumentNumber, pc.personName AS clientName,\n" +
                                                        "pe.personName AS employeeName,\n" +
                                                        "o.orderDate, o.orderDeliveredDate, o.orderStatus,\n" +
                                                        "o.subtotal, o.igv, o.deliveryCost, o.total, o.phoneNumber, o.email, o.paymentMethod,\n" +
                                                        "o.addressDelivery, o.addressReferenceDelivery\n" +
                                                        "FROM [Business].[Order] o \n" +
                                                        "INNER JOIN [Business].[Person] pc ON o.clientUserId = pc.personId\n" +
                                                        "INNER JOIN [Business].[Person] pe ON o.employeeUserId = pe.personId\n" +
                                                        "WHERE [orderStatus] = ? ORDER BY orderDate DESC";
    private static final String FIND_ALL_ORDER = "SELECT o.orderId,pc.personDocument AS clientDocumentNumber, pc.personName AS clientName,\n" +
                                                "pe.personName AS employeeName,\n" +
                                                "o.orderDate, o.orderDeliveredDate, o.orderStatus,\n" +
                                                "o.subtotal, o.igv, o.deliveryCost, o.total, o.phoneNumber, o.email, o.paymentMethod,\n" +
                                                "o.addressDelivery, o.addressReferenceDelivery\n" +
                                                "FROM [Business].[Order] o \n" +
                                                "INNER JOIN [Business].[Person] pc ON o.clientUserId = pc.personId\n" +
                                                "INNER JOIN [Business].[Person] pe ON o.employeeUserId = pe.personId ORDER BY orderDate DESC";

    @Override
    public List<OrderView> findAllOrders(List<String> orderStatus) {
        if (!CollectionUtils.isEmpty(orderStatus)) {
            switch (orderStatus.size()) {
                case 1:
                    return jdbcTemplate.query(FIND_ORDER_BY_STATUS, new Object[]{orderStatus.get(0)}, orderRowMapper);
                case 2:
                    return jdbcTemplate.query(FIND_ORDER_BY_STATUS_TWO, new Object[]{orderStatus.get(0), orderStatus.get(1)}, orderRowMapper);
                default:
                    break;
            }
        }

        return jdbcTemplate.query(FIND_ALL_ORDER, new Object[]{}, orderRowMapper);
    }

    @Override
    public String registerOrder(Order order) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withSchemaName(SCHEMA_BUSINESS)
                .withTableName(TBL_ORDER)
                .usingColumns("clientUserId", "employeeUserId", "orderDate", "orderStatus",
                        "subtotal", "igv", "deliveryCost", "total", "phoneNumber", "email",
                        "paymentMethod", "addressDelivery", "addressReferenceDelivery")
                .usingGeneratedKeyColumns("orderId");
        Map<String, Object> params = new HashMap<>();
        params.put("clientUserId", order.getClientUserId());
        params.put("employeeUserId", order.getEmployeeUserId());
        params.put("orderDate", order.getOrderDate());
        params.put("orderStatus", order.getOrderStatus());
        params.put("subtotal", order.getSubtotal());
        params.put("igv", order.getIgv());
        params.put("deliveryCost", order.getDeliveryCost());
        params.put("total", order.getTotal());
        params.put("phoneNumber", order.getPhoneNumber());
        params.put("email", order.getEmail());
        params.put("paymentMethod", order.getPaymentMethod());
        params.put("addressDelivery", order.getAddressDelivery());
        params.put("addressReferenceDelivery", order.getAddressReferenceDelivery());
        Number orderId = simpleJdbcInsert.executeAndReturnKey(params);
        return String.valueOf(orderId);
    }

    @Override
    public String updateOrder(Order order) {
        return null;
    }

    @Override
    public String deleteOrder(Long orderId) {
        return null;
    }
}
