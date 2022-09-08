package pe.perico.client.backend.db.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pe.perico.client.backend.domain.Parameter;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author X10144 on 17/02/2021
 */
@Component
public class ParameterRowMapper implements RowMapper<Parameter> {
    @Override
    public Parameter mapRow(ResultSet rs, int i) throws SQLException {
        return Parameter.builder()
                .Codigo(rs.getString("Codigo"))
                .Descripcion(rs.getString("Descripcion"))
                .build();
    }
}
