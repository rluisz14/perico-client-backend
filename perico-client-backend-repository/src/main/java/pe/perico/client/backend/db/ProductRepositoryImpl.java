package pe.perico.client.backend.db;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pe.perico.client.backend.db.rowmapper.ProductRowMapper;
import pe.perico.client.backend.domain.Product;

import java.util.List;
import java.util.Optional;

/**
 * @author rluisz14  on 08/10/2022
 */

@Slf4j
@Repository
@AllArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final JdbcTemplate jdbcTemplate;
    private final ProductRowMapper productRowMapper;

    private static final String FIND_PRODUCT_BY_CATEGORY_ID = "SELECT * FROM [Business].[Product] WHERE [categoryId] = ? AND [productStatus] = 'A'";
    private static final String FIND_PRODUCT_BY_PRODUCT_ID = "SELECT * FROM [Business].[Product] WHERE [productId] = ? AND [productStatus] = 'A'";

    @Override
    public Optional<Product> findProductById(Long productId) {
        Product product;
        try {
            product = jdbcTemplate.query(FIND_PRODUCT_BY_PRODUCT_ID, new Object[]{productId}, productRowMapper).get(0);
        } catch (IndexOutOfBoundsException e){
            product = null;
        }
        return Optional.ofNullable(product);
    }

    @Override
    public List<Product> findAllProducts() {
        return null;
    }

    @Override
    public List<Product> findProductByCategoryId(Long categoryId) {
        return jdbcTemplate.query(FIND_PRODUCT_BY_CATEGORY_ID, new Object[]{categoryId}, productRowMapper);
    }

    @Override
    public String registerProduct(Product product) {
        return null;
    }

    @Override
    public String updateProduct(Product product) {
        return null;
    }

    @Override
    public String deleteProduct(Long productId) {
        return null;
    }
}
