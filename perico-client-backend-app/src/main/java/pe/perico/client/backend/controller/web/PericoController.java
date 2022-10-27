package pe.perico.client.backend.controller.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import pe.perico.client.backend.controller.web.dto.CategoryResponseWebDto;
import pe.perico.client.backend.controller.web.dto.OrderRequestWebDto;
import pe.perico.client.backend.controller.web.dto.OrderResponseWebDto;
import pe.perico.client.backend.controller.web.dto.PriceDetailsRequestWebDto;
import pe.perico.client.backend.controller.web.dto.PriceDetailsResponseWebDto;
import pe.perico.client.backend.controller.web.dto.ProductResponseWebDto;
import pe.perico.client.backend.service.OrderService;
import pe.perico.client.backend.service.PriceDetailsService;
import pe.perico.client.backend.service.ProductService;
import pe.perico.client.backend.service.CategoryService;

import java.util.List;
import java.util.Objects;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/perico/v1/backend")
@Slf4j
public class PericoController {

    private static final String X_ORGANIZATION_ID_HEADER = "X-Organization-Id";

    private final CategoryService categoryService;
    private final ProductService productService;
    private final OrderService orderService;
    private final PriceDetailsService priceDetailsService;

    public PericoController(CategoryService categoryService,
                            ProductService productService,
                            OrderService orderService,
                            PriceDetailsService priceDetailsService) {
        super();
        this.categoryService = categoryService;
        this.productService = productService;
        this.orderService = orderService;
        this.priceDetailsService = priceDetailsService;
    }

    @GetMapping("/healthCheck")
    public HttpEntity<Void> healthCheck() {
        return ResponseEntity.status(HttpStatus.OK.value()).contentType(MediaType.APPLICATION_JSON).build();
    }

    @GetMapping("/orders/categories")
    public HttpEntity<CategoryResponseWebDto> getCategories(@RequestHeader MultiValueMap<String, String> headers) {
        Object organizationId = headers.get(X_ORGANIZATION_ID_HEADER.toLowerCase());
        log.info("Header is {}", organizationId);
        if(!Objects.isNull(organizationId) && !((List<?>) organizationId).isEmpty()
                && ((List<?>) organizationId).get(0).toString().equalsIgnoreCase("PERICO_CLIENT")){
            CategoryResponseWebDto response = categoryService.getCategories();
            return ResponseEntity.status(HttpStatus.OK.value())
                    .contentType(MediaType.APPLICATION_JSON).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CategoryResponseWebDto());
        }
    }

    @GetMapping("/orders/products")
    public HttpEntity<ProductResponseWebDto> getCategoryProducts(@RequestHeader MultiValueMap<String, String> headers, @RequestParam Long categoryId) {
        Object organizationId = headers.get(X_ORGANIZATION_ID_HEADER.toLowerCase());
        log.info("Header is {}", organizationId);
        if(!Objects.isNull(organizationId) && !((List<?>) organizationId).isEmpty()
                && ((List<?>) organizationId).get(0).toString().equalsIgnoreCase("PERICO_CLIENT")){
            ProductResponseWebDto response = productService.getProductByCategoryId(categoryId);
            return ResponseEntity.status(HttpStatus.OK.value())
                    .contentType(MediaType.APPLICATION_JSON).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ProductResponseWebDto());
        }
    }
    
    @PostMapping("/priceDetails")
    public HttpEntity<PriceDetailsResponseWebDto> calculatePriceDetails(@RequestHeader MultiValueMap<String, String> headers, @RequestBody PriceDetailsRequestWebDto priceDetailsRequestWebDto) {
        Object organizationId = headers.get(X_ORGANIZATION_ID_HEADER.toLowerCase());
        log.info("Header is {}", organizationId);
        if(!Objects.isNull(organizationId) && !((List<?>) organizationId).isEmpty()
                && ((List<?>) organizationId).get(0).toString().equalsIgnoreCase("PERICO_CLIENT")){
                    PriceDetailsResponseWebDto response = priceDetailsService.getPriceDetails(priceDetailsRequestWebDto);
            return ResponseEntity.status(HttpStatus.OK.value())
                    .contentType(MediaType.APPLICATION_JSON).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new PriceDetailsResponseWebDto());
        }
    }

    @PostMapping("/orders")
    public HttpEntity<OrderResponseWebDto> registerOrder(@RequestHeader MultiValueMap<String, String> headers, @RequestBody OrderRequestWebDto orderRequestWebDto) {
        Object organizationId = headers.get(X_ORGANIZATION_ID_HEADER.toLowerCase());
        log.info("Header is {}", organizationId);
        if(!Objects.isNull(organizationId) && !((List<?>) organizationId).isEmpty()
                && ((List<?>) organizationId).get(0).toString().equalsIgnoreCase("PERICO_CLIENT")){
            OrderResponseWebDto response = orderService.registerOrder(orderRequestWebDto);
            return ResponseEntity.status(HttpStatus.OK.value())
                    .contentType(MediaType.APPLICATION_JSON).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new OrderResponseWebDto());
        }
    }

}
