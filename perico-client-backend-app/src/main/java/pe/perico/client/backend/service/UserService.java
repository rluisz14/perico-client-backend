package pe.perico.client.backend.service;

import pe.perico.client.backend.controller.web.dto.UserResponseWebDto;

/**
 * @author rluisz14  on 08/10/2022
 */
public interface UserService {

    UserResponseWebDto login(String username, String password);
}
