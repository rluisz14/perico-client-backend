package pe.perico.client.backend.db.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pe.perico.client.backend.domain.UsersRoles;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author X10144 on 12/02/2021
 */
@Component
public class UsersRolesRowMapper implements RowMapper<UsersRoles> {
    @Override
    public UsersRoles mapRow(ResultSet rs, int i) throws SQLException {
        return UsersRoles.builder()
                .userRoleId(rs.getString("userRoleId"))
                .registerUser(rs.getString("registerUser"))
                .roleID(rs.getString("roleID"))
                .build();
    }
}
