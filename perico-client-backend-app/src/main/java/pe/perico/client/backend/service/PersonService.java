package pe.perico.client.backend.service;

import pe.perico.client.backend.controller.web.dto.PersonRequestWebDto;
import pe.perico.client.backend.controller.web.dto.PersonResponseWebDto;

/**
 * @author rluisz14  on 08/10/2022
 */
public interface PersonService {

    PersonResponseWebDto savePerson(PersonRequestWebDto personRequestWebDto);
}
