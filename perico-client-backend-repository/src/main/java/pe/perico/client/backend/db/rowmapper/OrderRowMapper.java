package pe.perico.client.backend.db.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pe.perico.client.backend.domain.Order;

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
public class OrderRowMapper implements RowMapper<Order> {

    @Override
    public Order mapRow(ResultSet rs, int i) throws SQLException {
        return Order.builder()
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
