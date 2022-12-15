package pe.perico.client.backend.db.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pe.perico.client.backend.domain.ProductDetail;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author rluisz14  on 08/10/2022
 */
@Component
public class ProductDetailRowMapper implements RowMapper<ProductDetail> {

    @Override
    public ProductDetail mapRow(ResultSet rs, int i) throws SQLException {
        return ProductDetail.builder()
                .productDetailId(rs.getLong("productDetailId"))
                .productId(rs.getLong("productId"))
                .supplyId(rs.getLong("supplyId"))
                .quantity(rs.getDouble("quantity"))
                .build();
    }
}
