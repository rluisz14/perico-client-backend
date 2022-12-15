package pe.perico.client.backend.db;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pe.perico.client.backend.db.rowmapper.ProductDetailRowMapper;
import pe.perico.client.backend.domain.ProductDetailView;

import java.util.List;

/**
 * @author rluisz14  on 08/10/2022
 */

@Slf4j
@Repository
@AllArgsConstructor
public class ProductDetailRepositoryImpl implements ProductDetailRepository {

    private final JdbcTemplate jdbcTemplate;
    private final ProductDetailRowMapper productDetailRowMapper;

    private static final String FIND_PRODUCT_DETAIL_BY_PRODUCT_ID = "SELECT pd.productDetailId, s.supplyName, s.metricUnits, pd.quantity, pv.providerName FROM [Business].[ProductDetail] pd \n" +
            "INNER JOIN [Business].[Product] p ON pd.productId = p.productId\n" +
            "INNER JOIN [Business].[Supply] s ON pd.supplyId = s.supplyId\n" +
            "INNER JOIN [Business].[Provider] pv ON s.providerId = pv.providerId\n" +
            "WHERE p.productId = ?";

    @Override
    public List<ProductDetailView> findProductDetailByProductId(Long productId) {
        return jdbcTemplate.query(FIND_PRODUCT_DETAIL_BY_PRODUCT_ID, new Object[]{productId}, productDetailRowMapper);
    }
}
