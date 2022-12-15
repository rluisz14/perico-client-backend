package pe.perico.client.backend.service;

import pe.perico.client.backend.controller.web.dto.ProductDetailResponseWebDto;
import pe.perico.client.backend.controller.web.dto.ProductResponseWebDto;

/**
 * @author rluisz14  on 08/10/2022
 */
public interface ProductService {

    ProductResponseWebDto getProductByCategoryId(Long categoryId);
    ProductDetailResponseWebDto findProductDetailByProductId(Long productId);
}
