package pe.perico.client.backend.db.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pe.perico.client.backend.domain.Supply;
import pe.perico.client.backend.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author rluisz14  on 08/10/2022
 */
@Component
public class SupplyRowMapper implements RowMapper<Supply> {
    @Override
    public Supply mapRow(ResultSet rs, int i) throws SQLException {
        return Supply.builder()
                .supplyId(rs.getLong("supplyId"))
                .providerId(rs.getLong("providerId"))
                .supplyName(rs.getString("supplyName"))
                .metricUnits(rs.getString("metricUnits"))
                .supplyCost(rs.getDouble("supplyCost"))
                .supplyStock(rs.getDouble("supplyStock"))
                .supplyRegisterDate(Util.fromTimestamp(rs,"supplyRegisterDate"))
                .supplyStatus(rs.getString("supplyStatus"))
                .build();
    }

}
