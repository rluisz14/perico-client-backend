package pe.perico.client.backend.db.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pe.perico.client.backend.domain.Category;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author rluisz14  on 08/10/2022
 */
@Component
public class CategoryRowMapper implements RowMapper<Category> {
    @Override
    public Category mapRow(ResultSet rs, int i) throws SQLException {
        return Category.builder()
                .categoryId(rs.getLong("categoryId"))
                .categoryName(rs.getString("categoryName"))
                .categoryDescription(rs.getString("categoryDescription"))
                .categoryPriceRange(rs.getString("categoryPriceRange"))
                .categoryImageUrl(rs.getString("categoryImageUrl"))
                .categoryStatus(rs.getString("categoryStatus"))
                .build();
    }
}
