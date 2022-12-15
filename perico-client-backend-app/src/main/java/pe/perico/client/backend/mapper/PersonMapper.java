package pe.perico.client.backend.mapper;

import org.springframework.stereotype.Component;
import pe.perico.client.backend.constants.Constants;
import pe.perico.client.backend.controller.web.dto.PersonRequestWebDto;
import pe.perico.client.backend.domain.Person;

import java.util.Objects;

/**
 * @author rluisz14  on 08/10/2022
 */
@Component
public class PersonMapper {

    public Person convertPersonRequestWebDtoToPerson(PersonRequestWebDto personRequestWebDto) {
        return Person.builder()
                .userType(personRequestWebDto.getUserType())
                .userStatus(Objects.nonNull(personRequestWebDto.getUserStatus()) ? personRequestWebDto.getUserStatus() : Constants.ACTIVE_CODE)
                .personDocument(personRequestWebDto.getDocumentNumber())
                .personName(personRequestWebDto.getName())
                .personPhoneNumber(personRequestWebDto.getPhoneNumber())
                .personEmail(personRequestWebDto.getEmail())
                .personAddress(personRequestWebDto.getAddress())
                .personAddressReference(personRequestWebDto.getAddressReference())
                .personBirthdate(personRequestWebDto.getBirthdate())
                .build();
    }
}
