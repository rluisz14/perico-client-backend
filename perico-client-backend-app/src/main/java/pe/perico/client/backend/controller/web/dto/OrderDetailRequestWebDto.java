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
public class OrderDetailRequestWebDto extends RepresentationModel<OrderDetailRequestWebDto> implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long offerId;
    private Long productId;
    private Double price;
    private Integer quantity;
    private Double subtotal;
}
