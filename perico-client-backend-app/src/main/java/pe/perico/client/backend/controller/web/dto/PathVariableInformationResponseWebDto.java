package pe.perico.client.backend.controller.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import pe.perico.client.backend.domain.PathVariable;

import java.io.Serializable;
import java.util.List;

/**
 * @author X10144 on 17/02/2021
 */
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PathVariableInformationResponseWebDto extends RepresentationModel<PathVariableInformationResponseWebDto> implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<PathVariable> pathVariableList;
}
