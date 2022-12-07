package pe.perico.client.backend.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.perico.client.backend.controller.web.dto.PersonRequestWebDto;
import pe.perico.client.backend.controller.web.dto.PersonResponseWebDto;
import pe.perico.client.backend.db.PersonRepository;
import pe.perico.client.backend.db.UserRepository;
import pe.perico.client.backend.mapper.PersonMapper;
import pe.perico.client.backend.mapper.UserMapper;

@Slf4j
@AllArgsConstructor
@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final UserRepository userRepository;
    private final PersonMapper personMapper;
    private final UserMapper userMapper;

    @Override
    public PersonResponseWebDto savePerson(PersonRequestWebDto personRequestWebDto) {
        PersonResponseWebDto personResponseWebDto = new PersonResponseWebDto();
        personResponseWebDto.setPersonId(personRepository.savePerson(personMapper.convertPersonRequestWebDtoToPerson(personRequestWebDto)));
        userRepository.saveUser(userMapper.convertPersonRequestWebDtoToUser(personRequestWebDto, Long.valueOf(personResponseWebDto.getPersonId())));
        return personResponseWebDto;
    }
}
