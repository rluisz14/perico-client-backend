package pe.perico.client.backend.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.perico.client.backend.controller.web.dto.ProductResponseWebDto;
import pe.perico.client.backend.db.ProductRepository;

@Slf4j
@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductResponseWebDto getProductByCategoryId(String categoryId) {
        ProductResponseWebDto productResponseWebDto = new ProductResponseWebDto();
        productResponseWebDto.setProducts(productRepository.findProductByCategoryId(categoryId));
        return productResponseWebDto;
    }
}
