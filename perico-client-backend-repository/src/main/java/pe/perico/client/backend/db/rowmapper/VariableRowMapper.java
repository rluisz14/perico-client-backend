package pe.perico.client.backend.db.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pe.perico.client.backend.domain.Variable;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author X10144 on 25/02/2021
 */
@Component
public class VariableRowMapper implements RowMapper<Variable> {
    @Override
    public Variable mapRow(ResultSet rs, int i) throws SQLException {
        return Variable.builder()
                .variableID(rs.getString("variableID"))
                .Descripcion(rs.getString("Descripcion"))
                .valorOrigen(rs.getString("valorOrigen"))
                .Orden(rs.getString("Orden"))
                .build();
    }
}
