package pe.perico.client.backend.db.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pe.perico.client.backend.domain.StatusMetrics;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author X10144 on 1/03/2021
 */
@Component
public class StatusMetricsRowMapper implements RowMapper<StatusMetrics> {
    @Override
    public StatusMetrics mapRow(ResultSet rs, int i) throws SQLException {
        return StatusMetrics.builder()
                .inProgressNumber(rs.getString("inProgressNumber"))
                .activatedNumber(rs.getString("activatedNumber"))
                .suspendedNumber(rs.getString("suspendedNumber"))
                .deletedNumber(rs.getString("deletedNumber"))
                .totalNumber(rs.getString("totalNumber"))
                .build();
    }
}
