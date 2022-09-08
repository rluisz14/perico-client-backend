package pe.perico.client.backend.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author X10144 on 17/02/2021
 */
@Data
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PathResumeView implements Serializable {
    private static final long serialVersionUID = 1L;

    private String pathID;
    private String pathEstado;
    private String Descripcion;
    private String Flujo;
    private String ValorOrigen;
    private String Tipo;
    private String Condicion;
    private String Valor;
    private String validacionEstado;
}
