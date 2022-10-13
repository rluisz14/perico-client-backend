package pe.perico.client.backend.db.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pe.perico.client.backend.domain.Product;
import pe.perico.client.backend.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author rluisz14  on 08/10/2022
 */
@Component
public class ProductRowMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int i) throws SQLException {
        return Product.builder()
                .productId(rs.getLong("productId"))
                .categoryId(rs.getLong("categoryId"))
                .productPrice(rs.getDouble("productPrice"))
                .productCost(rs.getDouble("productCost"))
                .productName(rs.getString("productName"))
                .productDescription(rs.getString("productDescription"))
                .productStock(rs.getInt("productStock"))
                .productRegisterDate(Util.fromTimestamp(rs,"productRegisterDate"))
                .productImageUrl(rs.getString("productImageUrl"))
                .productStatus(rs.getString("productStatus"))
                .build();
    }

}
