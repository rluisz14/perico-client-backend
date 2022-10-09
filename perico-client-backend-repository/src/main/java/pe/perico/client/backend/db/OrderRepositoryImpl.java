package pe.perico.client.backend.db;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import pe.perico.client.backend.domain.Order;

import java.time.ZoneId;
import java.time.ZonedDateTime;
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

    private static final String TBL_ORDER = "Order";
    private static final String SCHEMA_BUSINESS = "Business";
    private static final String INIT_STATUS = "RECIBIDA";
    @Override
    public List<Order> findAllOrders() {
        return null;
    }

    @Override
    public String registerOrder(Order order) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withSchemaName(SCHEMA_BUSINESS)
                .withTableName(TBL_ORDER)
                .usingColumns("clientUserId", "employeeUserId", "orderDate",
                        "orderDeliveredDate", "orderStatus")
                .usingGeneratedKeyColumns("orderId");
        Map<String, Object> params = new HashMap<>();
        params.put("clientUserId", order.getClientUserId());
        params.put("employeeUserId", order.getEmployeeUserId());
        params.put("orderDate", ZonedDateTime.now(ZoneId.of("America/Bogota")));
        params.put("orderDeliveredDate", order.getOrderDeliveredDate());
        params.put("orderStatus", INIT_STATUS);
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
