package pe.perico.client.backend.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.perico.client.backend.controller.web.dto.ProductDetailResponseWebDto;
import pe.perico.client.backend.controller.web.dto.ProductResponseWebDto;
import pe.perico.client.backend.db.ProductDetailRepository;
import pe.perico.client.backend.db.ProductRepository;

@Slf4j
@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductDetailRepository productDetailRepository;

    @Override
    public ProductResponseWebDto getProductByCategoryId(Long categoryId) {
        ProductResponseWebDto productResponseWebDto = new ProductResponseWebDto();
        productResponseWebDto.setProducts(productRepository.findProductByCategoryId(categoryId));
        return productResponseWebDto;
    }

    @Override
    public ProductDetailResponseWebDto findProductDetailByProductId(Long productId) {
        ProductDetailResponseWebDto productDetailResponseWebDto = new ProductDetailResponseWebDto();
        productDetailResponseWebDto.setProductDetails(productDetailRepository.findProductDetailViewByProductId(productId));
        return productDetailResponseWebDto;
    }
}
