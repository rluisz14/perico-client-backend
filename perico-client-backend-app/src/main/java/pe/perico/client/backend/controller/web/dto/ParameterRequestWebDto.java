package pe.perico.client.backend.controller.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import pe.perico.client.backend.domain.Parameter;

import java.io.Serializable;

/**
 * @author X10144 on 17/02/2021
 */
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ParameterRequestWebDto extends RepresentationModel<ParameterRequestWebDto> implements Serializable {
    private static final long serialVersionUID = 1L;

    private boolean register;
    private Parameter parameter;
}
