package pe.perico.client.backend.mapper;

import org.springframework.stereotype.Component;
import pe.perico.client.backend.constants.Constants;
import pe.perico.client.backend.controller.web.dto.PersonRequestWebDto;
import pe.perico.client.backend.domain.User;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;

/**
 * @author rluisz14  on 08/10/2022
 */
@Component
public class UserMapper {

    public User convertPersonRequestWebDtoToUser(PersonRequestWebDto personRequestWebDto, Long personId) {
        return User.builder()
                .personId(personId)
                .userName(personRequestWebDto.getUserName())
                .userPassword(personRequestWebDto.getUserPassword())
                .userType(personRequestWebDto.getUserType())
                .userCreationDate(LocalDateTime.now(ZoneId.of(Constants.ZONE_AMERICA)))
                .userStatus(Objects.nonNull(personRequestWebDto.getUserStatus()) ? personRequestWebDto.getUserStatus() : Constants.ACTIVE_CODE)
                .build();
    }
}
