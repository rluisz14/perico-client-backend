package pe.perico.client.backend.db;

import pe.perico.client.backend.domain.User;

import java.util.Optional;

/**
 * @author rluisz14  on 08/10/2022
 */
public interface UserRepository {

    Optional<User> findUserByType(String userType);
    Optional<User> findUserByPersonDocument(String personDocument);
}
