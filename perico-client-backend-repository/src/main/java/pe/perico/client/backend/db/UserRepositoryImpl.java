package pe.perico.client.backend.db;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pe.perico.client.backend.db.rowmapper.UserRowMapper;
import pe.perico.client.backend.domain.User;

import java.util.Optional;

/**
 * @author rluisz14  on 08/10/2022
 */

@Slf4j
@Repository
@AllArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;
    private final UserRowMapper userRowMapper;

    private static final String FIND_USER_BY_TYPE = "SELECT * FROM [Business].[User] WHERE userType = ? AND userStatus = 'A'";
    private static final String FIND_USER_BY_PERSON_DOCUMENT = "SELECT u.* FROM [Business].[User] u INNER JOIN [Business].[Person] p ON u.personId = p.personId WHERE p.personDocument = ?";

    @Override
    public Optional<User> findUserByType(String userType) {
        User user;
        try {
            user = jdbcTemplate.query(FIND_USER_BY_TYPE, new Object[]{userType}, userRowMapper).get(0);
        } catch (IndexOutOfBoundsException e){
            user = null;
        }
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> findUserByPersonDocument(String personDocument) {
        User user;
        try {
            user = jdbcTemplate.query(FIND_USER_BY_PERSON_DOCUMENT, new Object[]{personDocument}, userRowMapper).get(0);
        } catch (IndexOutOfBoundsException e){
            user = null;
        }
        return Optional.ofNullable(user);
    }
}
