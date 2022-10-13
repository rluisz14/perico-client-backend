package pe.perico.client.backend.db;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import pe.perico.client.backend.domain.OrderDetail;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rluisz14  on 08/10/2022
 */

@Slf4j
@Repository
@AllArgsConstructor
public class OrderDetailRepositoryImpl implements OrderDetailRepository {

    private final JdbcTemplate jdbcTemplate;

    private static final String TBL_ORDER_DETAIL = "[OrderDetail]";
    private static final String SCHEMA_BUSINESS = "[Business]";

    @Override
    public String registerOrderDetail(OrderDetail orderDetail) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withSchemaName(SCHEMA_BUSINESS)
                .withTableName(TBL_ORDER_DETAIL)
                .usingColumns("orderId", "productId", "price", "quantity")
                .usingGeneratedKeyColumns("orderDetailId");
        Map<String, Object> params = new HashMap<>();
        params.put("orderId", orderDetail.getOrderId());
        params.put("productId", orderDetail.getProductId());
        params.put("price", orderDetail.getPrice());
        params.put("quantity", orderDetail.getQuantity());
        Number orderDetailId = simpleJdbcInsert.executeAndReturnKey(params);
        return String.valueOf(orderDetailId);
    }
}
