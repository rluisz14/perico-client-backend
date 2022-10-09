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
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long personId;
    private String personName;
    private String personLastName;
    private String personPhoneNumber;
    private String personAddress;
    private String personAddressReference;
    private String personBirthday;
}
