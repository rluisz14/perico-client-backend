package pe.perico.client.backend.controller.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

/**
 * @author rluisz14 on 08/10/2022
 */
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductOrderRequestWebDto extends RepresentationModel<ProductOrderRequestWebDto> implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long productId;
    private Long categoryId;
    private Double productPrice;
    private Integer quantity;
}
