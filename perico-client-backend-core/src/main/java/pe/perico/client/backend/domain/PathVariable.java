package pe.perico.client.backend.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author X10144 on 25/02/2021
 */
@Data
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PathVariable implements Serializable {
    private static final long serialVersionUID = 1L;

    private String pathVariableID;
    private String variableID;
    private String pathID;
    private String Tipo;
    private String Condicion;
    private String Orden;
    private String Estado;
}
