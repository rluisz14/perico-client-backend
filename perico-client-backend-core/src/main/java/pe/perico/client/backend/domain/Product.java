package pe.perico.client.backend.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author rluisz14 on 08/10/2022
 */
@Data
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long productId;
    private Long categoryId;
    private String productName;
    private String productDescription;
    private Double productPrice;
    private Double productCost;
    private Integer productStock;
    private LocalDateTime productRegisterDate;
    private String productImageUrl;
    private String productStatus;
}
