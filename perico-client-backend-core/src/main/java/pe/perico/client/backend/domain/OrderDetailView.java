package pe.perico.client.backend.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author rluisz14 on 08/10/2022
 */
@Data
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDetailView implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long orderDetailId;
    private Long productId;
    private String categoryName;
    private String productName;
    private Integer quantity;
    private Double price;
    private String productImageUrl;
}
