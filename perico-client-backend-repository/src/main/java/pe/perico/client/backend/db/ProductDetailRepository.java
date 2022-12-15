package pe.perico.client.backend.db;

import pe.perico.client.backend.domain.ProductDetailView;

import java.util.List;

/**
 * @author rluisz14  on 08/10/2022
 */
public interface ProductDetailRepository {

    List<ProductDetailView> findProductDetailByProductId(Long productId);
}
