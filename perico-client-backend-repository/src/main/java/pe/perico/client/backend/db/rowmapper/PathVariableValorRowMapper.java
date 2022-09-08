package pe.perico.client.backend.db.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pe.perico.client.backend.domain.PathVariableValor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author X10144 on 25/02/2021
 */
@Component
public class PathVariableValorRowMapper implements RowMapper<PathVariableValor> {
    @Override
    public PathVariableValor mapRow(ResultSet rs, int i) throws SQLException {
        return PathVariableValor.builder()
                .pathVariableValorID(rs.getString("pathVariableValorID"))
                .pathVariableID(rs.getString("pathVariableID"))
                .Valor(rs.getString("Valor"))
                .build();
    }
}
