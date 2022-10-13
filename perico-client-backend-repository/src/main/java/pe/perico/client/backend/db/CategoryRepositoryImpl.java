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

    private static final String FIND_ALL_CATEGORIES = "SELECT * FROM [Business].[Category] WHERE [categoryStatus] = 'A'";
    private static final String UPDATE_USER_ROLE= "UPDATE TBL_USER_ROLE SET registerUser = ?, roleID = ? WHERE userRoleId = ?";
    private static final String DELETE_USER_ROLE = "DELETE FROM TBL_USER_ROLE WHERE userRoleId = ?";

   /*
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
