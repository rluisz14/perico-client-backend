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
public class Supply implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long supplyId;
    private Long providerId;
    private String supplyName;
    private String metricUnits;
    private Double supplyCost;
    private Double supplyStock;
    private LocalDateTime supplyRegisterDate;
    private String supplyStatus;
}
