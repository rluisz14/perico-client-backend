package pe.perico.client.backend.db.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pe.perico.client.backend.domain.PathVariable;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author X10144 on 25/02/2021
 */
@Component
public class PathVariableRowMapper implements RowMapper<PathVariable> {
    @Override
    public PathVariable mapRow(ResultSet rs, int i) throws SQLException {
        return PathVariable.builder()
                .pathVariableID(rs.getString("pathVariableID"))
                .variableID(rs.getString("variableID"))
                .pathID(rs.getString("pathID"))
                .Tipo(rs.getString("Tipo"))
                .Condicion(rs.getString("Condicion"))
                .Orden(rs.getString("Orden"))
                .Estado(rs.getString("Estado"))
                .build();
    }
}
