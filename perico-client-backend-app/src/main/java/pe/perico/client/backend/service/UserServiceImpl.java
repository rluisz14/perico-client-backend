package pe.perico.client.backend.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import pe.perico.client.backend.constants.Constants;
import pe.perico.client.backend.controller.web.dto.UserResponseWebDto;
import pe.perico.client.backend.db.UserRepository;
import pe.perico.client.backend.domain.User;

import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponseWebDto login(String username, String password) {
        Optional<User> userOptional = userRepository.findUserByUserNameAndPassword(username, password);
        if (userOptional.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, Constants.USER_NOT_EXISTS);
        }

        User user = userOptional.get();

        if (!Constants.ACTIVE_CODE.equals(user.getUserStatus())) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, Constants.USER_INACTIVE);
        }

        UserResponseWebDto userResponseWebDto = new UserResponseWebDto();
        userResponseWebDto.setUserId(user.getUserId());
        userResponseWebDto.setUserName(user.getUserName());
        userResponseWebDto.setUserType(user.getUserType());
        userResponseWebDto.setUserStatus(user.getUserStatus());


        return userResponseWebDto;
    }
}
