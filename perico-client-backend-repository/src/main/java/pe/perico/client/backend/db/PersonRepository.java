package pe.perico.client.backend.db;

import pe.perico.client.backend.domain.Person;
import pe.perico.client.backend.domain.User;

import java.util.Optional;

/**
 * @author rluisz14  on 08/10/2022
 */
public interface PersonRepository {

    String savePerson(Person person);
    Optional<Person> findPersonByDocument(String personDocument);
    Optional<Person> findPersonByEmail(String email);
}
