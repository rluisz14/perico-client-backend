package pe.perico.client.backend.db.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pe.perico.client.backend.domain.ProductDetailView;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author rluisz14  on 08/10/2022
 */
@Component
public class ProductDetailViewRowMapper implements RowMapper<ProductDetailView> {

    @Override
    public ProductDetailView mapRow(ResultSet rs, int i) throws SQLException {
        return ProductDetailView.builder()
                .productDetailId(rs.getLong("productDetailId"))
                .supplyName(rs.getString("supplyName"))
                .metricUnits(rs.getString("metricUnits"))
                .quantity(rs.getDouble("quantity"))
                .providerName(rs.getString("providerName"))
                .build();
    }
}
