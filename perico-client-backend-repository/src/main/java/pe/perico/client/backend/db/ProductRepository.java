package pe.perico.client.backend.db;

import pe.perico.client.backend.domain.Product;

import java.util.List;
import java.util.Optional;

/**
 * @author rluisz14  on 08/10/2022
 */
public interface ProductRepository {

    Optional<Product> findProductById(Long productId);
    List<Product> findAllProducts();
    List<Product> findProductByCategoryId(Long categoryId);
    String registerProduct(Product product);
    String updateProduct(Product product);
    String deleteProduct(Long productId);
}
