package pe.perico.client.backend.db.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pe.perico.client.backend.domain.User;
import pe.perico.client.backend.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author rluisz14  on 08/10/2022
 */
@Component
public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {
        return User.builder()
                .userId(rs.getLong("userId"))
                .personId(rs.getLong("personId"))
                .userName(rs.getString("userName"))
                .userPassword(rs.getString("userPassword"))
                .userType(rs.getString("userType"))
                .userCreationDate(Util.fromTimestamp(rs,"userCreationDate"))
                .userStatus(rs.getString("userStatus"))
                .build();
    }
}
