package pe.perico.client.backend.db.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pe.perico.client.backend.domain.OrderView;
import pe.perico.client.backend.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author rluisz14  on 08/10/2022
 */
@Component
public class OrderRowMapper implements RowMapper<OrderView> {

    @Override
    public OrderView mapRow(ResultSet rs, int i) throws SQLException {
        return OrderView.builder()
                .orderId(rs.getLong("orderId"))
                .clientDocumentNumber(rs.getString("clientDocumentNumber"))
                .clientName(rs.getString("clientName"))
                .employeeName(rs.getString("employeeName"))
                .orderDate(Util.fromTimestamp(rs,"orderDate"))
                .orderDeliveredDate(Util.fromTimestamp(rs,"orderDeliveredDate"))
                .orderStatus(rs.getString("orderStatus"))
                .subtotal(rs.getDouble("subtotal"))
                .igv(rs.getDouble("igv"))
                .deliveryCost(rs.getDouble("deliveryCost"))
                .total(rs.getDouble("total"))
                .phoneNumber(rs.getString("phoneNumber"))
                .email(rs.getString("email"))
                .paymentMethod(rs.getString("paymentMethod"))
                .addressDelivery(rs.getString("addressDelivery"))
                .addressReferenceDelivery(rs.getString("addressReferenceDelivery"))
                .build();
    }


}
