package pe.perico.client.backend.controller.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import pe.perico.client.backend.domain.Product;

import java.io.Serializable;
import java.util.List;

/**
 * @author rluisz14 on 08/10/2022
 */
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductResponseWebDto extends RepresentationModel<ProductResponseWebDto> implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Product> products;
}