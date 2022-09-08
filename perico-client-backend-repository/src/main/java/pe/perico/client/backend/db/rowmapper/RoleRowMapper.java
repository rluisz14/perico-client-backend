package pe.perico.client.backend.db.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pe.perico.client.backend.domain.Role;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author X10144 on 12/02/2021
 */
@Component
public class RoleRowMapper implements RowMapper<Role> {
    @Override
    public Role mapRow(ResultSet rs, int i) throws SQLException {
        return Role.builder()
                .roleID(rs.getString("roleID"))
                .roleName(rs.getString("roleName"))
                .build();
    }
}
