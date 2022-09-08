package pe.perico.client.backend.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DetailsMethod implements Serializable {
    private static final long serialVersionUID = 1L;

    private String code;
    private String value;
}
