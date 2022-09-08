package pe.perico.client.backend.db.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pe.perico.client.backend.domain.DetailsMethod;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author X10144 on 17/02/2021
 */
@Component
public class DetailsMethodRowMapper implements RowMapper<DetailsMethod> {
    @Override
    public DetailsMethod mapRow(ResultSet rs, int i) throws SQLException {
        return DetailsMethod.builder()
                .code(rs.getString("code").trim())
                .value(rs.getString("value"))
                .build();
    }
}
