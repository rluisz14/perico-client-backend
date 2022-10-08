package pe.perico.client.backend.db.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pe.perico.client.backend.domain.UserRole;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author X10144 on 12/02/2021
 */
@Component
public class UserRoleRowMapper implements RowMapper<UserRole> {
    @Override
    public UserRole mapRow(ResultSet rs, int i) throws SQLException {
        return UserRole.builder()
                .registerUser(rs.getString("registerUser"))
                .roleName(rs.getString("roleName"))
                .build();
    }
}
