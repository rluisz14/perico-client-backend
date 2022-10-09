package pe.perico.client.backend.db;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pe.perico.client.backend.db.rowmapper.CategoryRowMapper;
import pe.perico.client.backend.domain.Category;

import java.util.List;
import java.util.Optional;

/**
 * @author rluisz14  on 08/10/2022
 */

@Slf4j
@Repository
@AllArgsConstructor
public class CategoryRepositoryImpl implements CategoryRepository {

    private final JdbcTemplate jdbcTemplate;
    private final CategoryRowMapper categoryRowMapper;

    private static final String FIND_USER_ROLE_BY_REGISTER_NAME = "SELECT ur.registerUser, r.roleName FROM TBL_USER_ROLE as ur INNER JOIN TBL_ROLE as r ON ur.roleID = r.roleID WHERE registerUser = ?";
    private static final String FIND_ALL_CATEGORIES = "SELECT * FROM [Business].[Category]";
    private static final String FIND_ALL_USERS_ROLES = "SELECT * FROM TBL_USER_ROLE";
    private static final String TBL_USER_ROLE = "TBL_USER_ROLE";
    private static final String UPDATE_USER_ROLE= "UPDATE TBL_USER_ROLE SET registerUser = ?, roleID = ? WHERE userRoleId = ?";
    private static final String DELETE_USER_ROLE = "DELETE FROM TBL_USER_ROLE WHERE userRoleId = ?";

   /* public Optional<UserRole> findUserRoleByRegisterName(String registerName) {
        UserRole userRole;
        try {
            userRole = jdbcTemplate.query(FIND_USER_ROLE_BY_REGISTER_NAME, new Object[]{registerName}, userRoleRowMapper).get(0);
        }catch (IndexOutOfBoundsException e){
            userRole = null;
        }
        return Optional.ofNullable(userRole);
    }

    public List<Role> findAllRoles() {
        return jdbcTemplate.query(FIND_ALL_ROLES, new Object[]{}, roleRowMapper);
    }

    public List<UsersRoles> findAllUsersRoles() {
        return jdbcTemplate.query(FIND_ALL_USERS_ROLES, new Object[]{}, usersRolesRowMapper);
    }

    public String registerNewUsersRoles(UsersRoles usersRoles) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName(TBL_USER_ROLE)
                .usingColumns("registerUser", "roleID")
                .usingGeneratedKeyColumns("userRoleId");
        Map<String, Object> params = new HashMap<>();
        params.put("registerUser", usersRoles.getRegisterUser());
        params.put("roleID", usersRoles.getRoleID());
        Number userRoleId = simpleJdbcInsert.executeAndReturnKey(params);
        return String.valueOf(userRoleId);
    }

    public String updateUsersRoles(UsersRoles usersRoles) {
        int updated = jdbcTemplate.update(UPDATE_USER_ROLE,
                usersRoles.getRegisterUser(),
                usersRoles.getRoleID(),
                usersRoles.getUserRoleId());
        return String.valueOf(updated);
    }

    public String deleteUsersRoles(String userRoleId) {
        int deleted = jdbcTemplate.update(DELETE_USER_ROLE, userRoleId);
        return String.valueOf(deleted);
    }*/

    @Override
    public Optional<Category> findCategoryById(String categoryId) {
        return Optional.empty();
    }

    @Override
    public List<Category> findAllCategories() {
        return jdbcTemplate.query(FIND_ALL_CATEGORIES, new Object[]{}, categoryRowMapper);
    }

    @Override
    public String registerCategory(Category category) {
        return null;
    }

    @Override
    public String updateCategory(Category category) {
        return null;
    }

    @Override
    public String deleteCategory(Long categoryId) {
        return null;
    }
}
