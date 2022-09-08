package pe.perico.client.backend.db.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pe.perico.client.backend.domain.PathMethodParameter;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author X10144 on 17/02/2021
 */
@Component
public class PathMethodParameterRowMapper implements RowMapper<PathMethodParameter> {
    @Override
    public PathMethodParameter mapRow(ResultSet rs, int i) throws SQLException {
        return PathMethodParameter.builder()
                .pathID(rs.getString("pathID"))
                .Method(rs.getString("Method"))
                .Valor(rs.getString("Valor"))
                .build();
    }
}
