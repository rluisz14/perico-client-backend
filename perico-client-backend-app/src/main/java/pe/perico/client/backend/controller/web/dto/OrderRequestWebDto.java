package pe.perico.client.backend.controller.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.List;

/**
 * @author rluisz14 on 08/10/2022
 */
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderRequestWebDto extends RepresentationModel<OrderRequestWebDto> implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long employeeUserId;
    private Long clientUserId;
    private String clientDocumentNumber;
    List<ProductOrderRequestWebDto> products;
}
