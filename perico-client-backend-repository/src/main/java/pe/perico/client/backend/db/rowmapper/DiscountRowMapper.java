package pe.perico.client.backend.db.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pe.perico.client.backend.domain.Discount;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author rluisz14  on 08/10/2022
 */
@Component
public class DiscountRowMapper implements RowMapper<Discount> {
    @Override
    public Discount mapRow(ResultSet rs, int i) throws SQLException {
        return Discount.builder()
                .discountId(rs.getLong("discountId"))
                .categoryId(rs.getLong("categoryId"))
                .discountPercentage(rs.getDouble("discountPercentage"))
                .discountDescription(rs.getString("discountDescription"))
                .build();
    }
}
