package pe.perico.client.backend.controller.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import pe.perico.client.backend.service.CategoryProductsService;
import pe.perico.client.backend.service.OrdersCategoryService;

import java.util.List;
import java.util.Objects;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/perico/v1/backend")
@Slf4j
public class PericoController {

    private static final String X_ORGANIZATION_ID_HEADER = "X-Organization-Id";

    private final OrdersCategoryService ordersCategoryService;
    private final CategoryProductsService categoryProductsService;

    public PericoController(OrdersCategoryService ordersCategoryService,
                            CategoryProductsService categoryProductsService) {
        super();
        this.ordersCategoryService = ordersCategoryService;
        this.categoryProductsService = categoryProductsService;
    }

    @GetMapping("/healthCheck")
    public HttpEntity<Void> healthCheck(
            @RequestHeader(name = X_ORGANIZATION_ID_HEADER) String organizationId) {
        return ResponseEntity.status(HttpStatus.OK.value()).contentType(MediaType.APPLICATION_JSON).build();
    }

    @PostMapping("/orders/categories")
    public HttpEntity<String> getOrdersCategory(@RequestHeader MultiValueMap<String, String> headers) {
        Object organizationId = headers.get(X_ORGANIZATION_ID_HEADER.toLowerCase());
        log.info("Header is {}", organizationId);
        if(!Objects.isNull(organizationId) && !((List<?>) organizationId).isEmpty()
                && ((List<?>) organizationId).get(0).toString().equalsIgnoreCase("PERICO_CLIENT")){
            String response = ordersCategoryService.getOrdersCategoryLink();
            return ResponseEntity.status(HttpStatus.OK.value())
                    .contentType(MediaType.APPLICATION_JSON).body(response);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
        }
    }

    @PostMapping("/orders/products")
    public HttpEntity<String> getCategoryProducts(@RequestHeader MultiValueMap<String, String> headers) {
        Object organizationId = headers.get(X_ORGANIZATION_ID_HEADER.toLowerCase());
        log.info("Header is {}", organizationId);
        if(!Objects.isNull(organizationId) && !((List<?>) organizationId).isEmpty()
                && ((List<?>) organizationId).get(0).toString().equalsIgnoreCase("PERICO_CLIENT")){
            String response = categoryProductsService.getCategoryProductsLink();
            return ResponseEntity.status(HttpStatus.OK.value())
                    .contentType(MediaType.APPLICATION_JSON).body(response);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
        }
    }

}
