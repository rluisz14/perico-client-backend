package pe.perico.client.backend.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author X10144 on 23/02/2021
 */
@Data
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PathMethod implements Serializable {
    private static final long serialVersionUID = 1L;

    private String pathMethodID;
    private String pathID;
    private String Method;
}
