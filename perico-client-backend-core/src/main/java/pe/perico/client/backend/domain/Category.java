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
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long categoryId;
    private String categoryName;
    private String categoryDescription;
    private String categoryPriceRange;
    private String categoryImageUrl;
    private String categoryStatus;
}
