package pe.perico.client.backend.db;

import pe.perico.client.backend.domain.Person;

/**
 * @author rluisz14  on 08/10/2022
 */
public interface PersonRepository {

    String savePerson(Person person);
}