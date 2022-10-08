package pe.perico.client.backend.controller.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

/**
 * @author X10144 on 9/02/2021
 */
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SecurityRequestWebDto extends RepresentationModel<SecurityRequestWebDto> implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
}
