package pe.perico.client.backend.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.perico.client.backend.controller.web.dto.ProductDetailResponseWebDto;
import pe.perico.client.backend.controller.web.dto.ProductResponseWebDto;
import pe.perico.client.backend.db.ProductDetailRepository;
import pe.perico.client.backend.db.ProductRepository;
import pe.perico.client.backend.db.SupplyRepository;
import pe.perico.client.backend.domain.Product;
import pe.perico.client.backend.domain.ProductDetail;
import pe.perico.client.backend.domain.Supply;

import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductDetailRepository productDetailRepository;
    private final SupplyRepository supplyRepository;

    @Override
    public ProductResponseWebDto getProductByCategoryId(Long categoryId) {
        ProductResponseWebDto productResponseWebDto = new ProductResponseWebDto();
        List<Product> products = productRepository.findProductByCategoryId(categoryId);
        products.forEach(product -> {
            product.setHasStock(Boolean.TRUE);
            List<ProductDetail> productDetails = productDetailRepository.findProductDetailByByProductId(product.getProductId());
            productDetails.forEach(productDetail -> {
                Optional<Supply> supplyOptional = supplyRepository.findSupplyBySupplyId(productDetail.getSupplyId());
                if (supplyOptional.isEmpty() || supplyOptional.get().getSupplyStock() < productDetail.getQuantity()) {
                    product.setHasStock(Boolean.FALSE);
                }
            });
        });
        productResponseWebDto.setProducts(products);
        return productResponseWebDto;
    }

    @Override
    public ProductDetailResponseWebDto findProductDetailByProductId(Long productId) {
        ProductDetailResponseWebDto productDetailResponseWebDto = new ProductDetailResponseWebDto();
        productDetailResponseWebDto.setProductDetails(productDetailRepository.findProductDetailViewByProductId(productId));
        return productDetailResponseWebDto;
    }
}
