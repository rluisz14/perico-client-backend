package pe.perico.client.backend.db.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pe.perico.client.backend.domain.PathMethod;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author X10144 on 17/02/2021
 */
@Component
public class PathMethodRowMapper implements RowMapper<PathMethod> {
    @Override
    public PathMethod mapRow(ResultSet rs, int i) throws SQLException {
        return PathMethod.builder()
                .pathMethodID(rs.getString("pathMethodID"))
                .pathID(rs.getString("pathID"))
                .Method(rs.getString("Method"))
                .build();
    }
}
