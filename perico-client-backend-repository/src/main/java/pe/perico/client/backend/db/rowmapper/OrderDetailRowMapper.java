package pe.perico.client.backend.db.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pe.perico.client.backend.domain.OrderDetailView;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author rluisz14  on 08/10/2022
 */
@Component
public class OrderDetailRowMapper implements RowMapper<OrderDetailView> {

    @Override
    public OrderDetailView mapRow(ResultSet rs, int i) throws SQLException {
        return OrderDetailView.builder()
                .orderDetailId(rs.getLong("orderDetailId"))
                .productId(rs.getLong("productId"))
                .productName(rs.getString("productName"))
                .categoryName(rs.getString("categoryName"))
                .quantity(rs.getInt("quantity"))
                .price(rs.getDouble("price"))
                .productImageUrl(rs.getString("productImageUrl"))
                .build();
    }
}
