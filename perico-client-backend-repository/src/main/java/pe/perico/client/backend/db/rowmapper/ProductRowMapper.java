package pe.perico.client.backend.db.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pe.perico.client.backend.domain.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author rluisz14  on 08/10/2022
 */
@Component
public class ProductRowMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int i) throws SQLException {
        return Product.builder()
                .productId(rs.getLong("productId"))
                .categoryId(rs.getLong("categoryId"))
                .productPrice(rs.getDouble("productPrice"))
                .productCost(rs.getDouble("productCost"))
                .productName(rs.getString("productName"))
                .productDescription(rs.getString("productDescription"))
                .productStock(rs.getInt("productStock"))
                .productRegisterDate(fromTimestamp(rs,"productRegisterDate"))
                .productImageUrl(rs.getString("productImageUrl"))
                .productStatus(rs.getString("productStatus"))
                .build();
    }

    public static ZonedDateTime fromTimestamp(ResultSet rs, String column)
            throws SQLException {
        Timestamp timestamp = rs.getTimestamp(column);
        return getDateTime(timestamp);
    }

    public static ZonedDateTime getDateTime(Timestamp timestamp) {
        return timestamp != null ? ZonedDateTime.ofInstant(
                Instant.ofEpochMilli(timestamp.getTime()), ZoneId.of("America/Bogota")) : null;
    }
}
