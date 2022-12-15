package pe.perico.client.backend.db;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import pe.perico.client.backend.db.rowmapper.UserRowMapper;
import pe.perico.client.backend.domain.User;

import java.util.HashMap;
import java.util.Map;
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

    private static final String TBL_USER = "[User]";
    private static final String SCHEMA_BUSINESS = "[Business]";
    private static final String FIND_USER_BY_TYPE = "SELECT * FROM [Business].[User] WHERE userType = ? AND userStatus = 'A'";
    private static final String FIND_USER_BY_PERSON_DOCUMENT = "SELECT u.* FROM [Business].[User] u INNER JOIN [Business].[Person] p ON u.personId = p.personId WHERE p.personDocument = ?";
    private static final String FIND_USER_BY_USERNAME_PASSWORD = "SELECT * FROM [Business].[User] WHERE userName = ? AND userPassword = ?";
    private static final String FIND_USER_BY_USERNAME = "SELECT * FROM [Business].[User] WHERE userName = ?";

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

    @Override
    public Optional<User> findUserByUserNameAndPassword(String username, String password) {
        User user;
        try {
            user = jdbcTemplate.query(FIND_USER_BY_USERNAME_PASSWORD, new Object[]{username, password}, userRowMapper).get(0);
        } catch (IndexOutOfBoundsException e){
            user = null;
        }
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> findUserByUserName(String username) {
        User user;
        try {
            user = jdbcTemplate.query(FIND_USER_BY_USERNAME, new Object[]{username}, userRowMapper).get(0);
        } catch (IndexOutOfBoundsException e){
            user = null;
        }
        return Optional.ofNullable(user);
    }

    @Override
    public String saveUser(User user) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withSchemaName(SCHEMA_BUSINESS)
                .withTableName(TBL_USER)
                .usingColumns("personId", "userName", "userPassword", "userType",
                        "userCreationDate", "userStatus")
                .usingGeneratedKeyColumns("orderId");
        Map<String, Object> params = new HashMap<>();
        params.put("personId", user.getPersonId());
        params.put("userName", user.getUserName());
        params.put("userPassword", user.getUserPassword());
        params.put("userType", user.getUserType());
        params.put("userCreationDate", user.getUserCreationDate());
        params.put("userStatus", user.getUserStatus());
        Number userId = simpleJdbcInsert.executeAndReturnKey(params);
        return String.valueOf(userId);
    }
}
