package pe.perico.client.backend.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import pe.perico.client.backend.constants.Constants;
import pe.perico.client.backend.controller.web.dto.PersonRequestWebDto;
import pe.perico.client.backend.controller.web.dto.PersonResponseWebDto;
import pe.perico.client.backend.db.PersonRepository;
import pe.perico.client.backend.db.UserRepository;
import pe.perico.client.backend.domain.Person;
import pe.perico.client.backend.domain.User;
import pe.perico.client.backend.mapper.PersonMapper;
import pe.perico.client.backend.mapper.UserMapper;

import java.util.Optional;

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
        Optional<User> userOptional = userRepository.findUserByUserName(personRequestWebDto.getUserName());
        Optional<Person> personOptionalByDocument = personRepository.findPersonByDocument(personRequestWebDto.getDocumentNumber());
        Optional<Person> personOptionalByEmail = personRepository.findPersonByEmail(personRequestWebDto.getEmail());

        if (userOptional.isPresent() && personOptionalByDocument.isPresent() && personOptionalByEmail.isPresent()) {
            throw new HttpClientErrorException(HttpStatus.CONFLICT, Constants.USERNAME_EMAIL_DOCUMENT_ALREADY_EXISTS);
        } else if (userOptional.isPresent() && personOptionalByDocument.isPresent() && personOptionalByEmail.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.CONFLICT, Constants.USERNAME_DOCUMENT_ALREADY_EXISTS);
        } else if (userOptional.isEmpty() && personOptionalByDocument.isPresent() && personOptionalByEmail.isPresent()) {
            throw new HttpClientErrorException(HttpStatus.CONFLICT, Constants.EMAIL_DOCUMENT_ALREADY_EXISTS);
        } else if (userOptional.isPresent() && personOptionalByDocument.isEmpty() && personOptionalByEmail.isPresent()) {
            throw new HttpClientErrorException(HttpStatus.CONFLICT, Constants.USERNAME_EMAIL_ALREADY_EXISTS);
        } else if (userOptional.isPresent() && personOptionalByDocument.isEmpty() && personOptionalByEmail.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.CONFLICT, Constants.USERNAME_ALREADY_EXISTS);
        } else if (userOptional.isEmpty() && personOptionalByDocument.isPresent() && personOptionalByEmail.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.CONFLICT, Constants.DOCUMENT_ALREADY_EXISTS);
        } else if (userOptional.isEmpty() && personOptionalByDocument.isEmpty() && personOptionalByEmail.isPresent()) {
            throw new HttpClientErrorException(HttpStatus.CONFLICT, Constants.EMAIL_ALREADY_EXISTS);
        }

        PersonResponseWebDto personResponseWebDto = new PersonResponseWebDto();
        personResponseWebDto.setPersonId(personRepository.savePerson(personMapper.convertPersonRequestWebDtoToPerson(personRequestWebDto)));
        userRepository.saveUser(userMapper.convertPersonRequestWebDtoToUser(personRequestWebDto, Long.valueOf(personResponseWebDto.getPersonId())));
        return personResponseWebDto;

    }
}
