package pe.perico.client.backend.controller.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import pe.perico.client.backend.constants.Constants;
import pe.perico.client.backend.controller.web.dto.*;
import pe.perico.client.backend.service.*;

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
    private final PersonService personService;
    private final UserService userService;

    public PericoController(CategoryService categoryService,
                            ProductService productService,
                            OrderService orderService,
                            PriceDetailsService priceDetailsService,
                            PersonService personService,
                            UserService userService) {
        super();
        this.categoryService = categoryService;
        this.productService = productService;
        this.orderService = orderService;
        this.priceDetailsService = priceDetailsService;
        this.personService = personService;
        this.userService = userService;
    }

    @GetMapping("/healthCheck")
    public HttpEntity<Void> healthCheck() {
        return ResponseEntity.status(HttpStatus.OK.value()).contentType(MediaType.APPLICATION_JSON).build();
    }

    @GetMapping("/orders/categories")
    public HttpEntity<CategoryResponseWebDto> getCategories(@RequestHeader MultiValueMap<String, String> headers) {
        if (validateHeader(headers)) {
            CategoryResponseWebDto response = categoryService.getCategories();
            return ResponseEntity.status(HttpStatus.OK.value())
                    .contentType(MediaType.APPLICATION_JSON).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CategoryResponseWebDto());
        }
    }

    @GetMapping("/orders/products")
    public HttpEntity<ProductResponseWebDto> getCategoryProducts(@RequestHeader MultiValueMap<String, String> headers, @RequestParam Long categoryId) {
        if (validateHeader(headers)) {
            ProductResponseWebDto response = productService.getProductByCategoryId(categoryId);
            return ResponseEntity.status(HttpStatus.OK.value())
                    .contentType(MediaType.APPLICATION_JSON).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ProductResponseWebDto());
        }
    }

    @GetMapping("/orders/product-details")
    public HttpEntity<ProductDetailResponseWebDto> getProductDetails(@RequestHeader MultiValueMap<String, String> headers, @RequestParam Long productId) {
        if (validateHeader(headers)) {
            ProductDetailResponseWebDto response = productService.findProductDetailByProductId(productId);
            return ResponseEntity.status(HttpStatus.OK.value())
                    .contentType(MediaType.APPLICATION_JSON).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ProductDetailResponseWebDto());
        }
    }
    
    @PostMapping("/priceDetails")
    public HttpEntity<PriceDetailsResponseWebDto> calculatePriceDetails(@RequestHeader MultiValueMap<String, String> headers, @RequestBody PriceDetailsRequestWebDto priceDetailsRequestWebDto) {
        if (validateHeader(headers)) {
                    PriceDetailsResponseWebDto response = priceDetailsService.getPriceDetails(priceDetailsRequestWebDto);
            return ResponseEntity.status(HttpStatus.OK.value())
                    .contentType(MediaType.APPLICATION_JSON).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new PriceDetailsResponseWebDto());
        }
    }

    @PostMapping("/orders")
    public HttpEntity<OrderResponseWebDto> registerOrder(@RequestHeader MultiValueMap<String, String> headers, @RequestBody OrderRequestWebDto orderRequestWebDto) {
        if (validateHeader(headers)) {
            try {
                OrderResponseWebDto response = orderService.registerOrder(orderRequestWebDto);
                return ResponseEntity.status(HttpStatus.OK.value())
                        .contentType(MediaType.APPLICATION_JSON).body(response);
            } catch (Exception e) {
                if (e.getMessage().contains(Constants.CLIENT_NOT_EXISTS))
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

                if (e.getMessage().contains(Constants.EMPLOYEE_NOT_EXISTS))
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/orders")
    public HttpEntity<ListOrderResponseWebDto> getOrders(@RequestHeader MultiValueMap<String, String> headers, @RequestParam(required = false) String orderStatus) {
        if (validateHeader(headers)) {
            ListOrderResponseWebDto response = orderService.findAllOrders(orderStatus);
            return ResponseEntity.status(HttpStatus.OK.value())
                    .contentType(MediaType.APPLICATION_JSON).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ListOrderResponseWebDto());
        }
    }

    @PostMapping("/users/login")
    public HttpEntity<UserResponseWebDto> loginPerson(@RequestHeader MultiValueMap<String, String> headers, @RequestBody PersonRequestWebDto personRequestWebDto) {
        if (validateHeader(headers)) {
            UserResponseWebDto response = userService.login(personRequestWebDto.getUserName(), personRequestWebDto.getUserPassword());
            return ResponseEntity.status(HttpStatus.OK.value())
                    .contentType(MediaType.APPLICATION_JSON).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new UserResponseWebDto());
        }
    }

    @PostMapping("/persons")
    public HttpEntity<PersonResponseWebDto> savePerson(@RequestHeader MultiValueMap<String, String> headers, @RequestBody PersonRequestWebDto personRequestWebDto) {
        if (validateHeader(headers)) {
            PersonResponseWebDto response = personService.savePerson(personRequestWebDto);
            return ResponseEntity.status(HttpStatus.OK.value())
                    .contentType(MediaType.APPLICATION_JSON).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new PersonResponseWebDto());
        }
    }

    private boolean validateHeader(MultiValueMap<String, String> headers) {
        Object organizationId = headers.get(X_ORGANIZATION_ID_HEADER.toLowerCase());
        log.info("Header is {}", organizationId);
        return !Objects.isNull(organizationId) && !((List<?>) organizationId).isEmpty()
                && ((List<?>) organizationId).get(0).toString().equalsIgnoreCase(Constants.PERICO_HEADER);
    }

}
