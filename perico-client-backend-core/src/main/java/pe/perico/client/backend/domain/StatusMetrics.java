package pe.perico.client.backend.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author X10144 on 1/03/2021
 */
@Data
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatusMetrics implements Serializable {
    private static final long serialVersionUID = 1L;

    private String inProgressNumber;
    private String activatedNumber;
    private String suspendedNumber;
    private String deletedNumber;
    private String totalNumber;
}