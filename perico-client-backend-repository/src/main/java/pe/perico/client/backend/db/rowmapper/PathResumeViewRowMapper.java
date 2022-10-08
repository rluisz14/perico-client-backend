package pe.perico.client.backend.db.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pe.perico.client.backend.domain.PathResumeView;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author X10144 on 17/02/2021
 */
@Component
public class PathResumeViewRowMapper implements RowMapper<PathResumeView> {
    @Override
    public PathResumeView mapRow(ResultSet rs, int i) throws SQLException {
        return PathResumeView.builder()
                .pathID(rs.getString("pathID"))
                .pathEstado(rs.getString("pathEstado"))
                .Descripcion(rs.getString("Descripcion"))
                .Flujo(rs.getString("Flujo"))
                .ValorOrigen(rs.getString("ValorOrigen"))
                .Tipo(rs.getString("Tipo"))
                .Condicion(rs.getString("Condicion"))
                .Valor(rs.getString("Valor"))
                .validacionEstado(rs.getString("validacionEstado"))
                .build();
    }
}
