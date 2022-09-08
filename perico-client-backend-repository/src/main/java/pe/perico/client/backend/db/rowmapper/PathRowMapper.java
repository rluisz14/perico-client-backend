package pe.perico.client.backend.db.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pe.perico.client.backend.domain.Path;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author X10144 on 17/02/2021
 */
@Component
public class PathRowMapper implements RowMapper<Path> {
    @Override
    public Path mapRow(ResultSet rs, int i) throws SQLException {
        return Path.builder()
                .pathID(rs.getString("pathID"))
                .Descripcion(rs.getString("Descripcion"))
                .Flujo(rs.getString("Flujo"))
                .Estado(rs.getString("Estado"))
                .Tipo(rs.getString("Tipo"))
                .build();
    }
}
