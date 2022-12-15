package pe.perico.client.backend.db;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import pe.perico.client.backend.db.rowmapper.PersonRowMapper;
import pe.perico.client.backend.domain.Person;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author rluisz14  on 08/10/2022
 */

@Slf4j
@Repository
@AllArgsConstructor
public class PersonRepositoryImpl implements PersonRepository {

    private final JdbcTemplate jdbcTemplate;
    private final PersonRowMapper personRowMapper;

    private static final String TBL_PERSON = "[Person]";
    private static final String SCHEMA_BUSINESS = "[Business]";
    private static final String FIND_PERSON_BY_DOCUMENT = "SELECT * FROM [Business].[Person] WHERE personDocument = ?";
    private static final String FIND_PERSON_BY_EMAIL = "SELECT * FROM [Business].[Person] WHERE personEmail = ?";

    @Override
    public String savePerson(Person person) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withSchemaName(SCHEMA_BUSINESS)
                .withTableName(TBL_PERSON)
                .usingColumns("personDocument", "personName", "personPhoneNumber","personEmail",
                        "personAddress", "personAddressReference", "personBirthdate")
                .usingGeneratedKeyColumns("orderId");
        Map<String, Object> params = new HashMap<>();
        params.put("personDocument", person.getPersonDocument());
        params.put("personName", person.getPersonName());
        params.put("personPhoneNumber", person.getPersonPhoneNumber());
        params.put("personEmail", person.getPersonEmail());
        params.put("personAddress", person.getPersonAddress());
        params.put("personAddressReference", person.getPersonAddressReference());
        params.put("personBirthdate", person.getPersonBirthdate());
        Number personId = simpleJdbcInsert.executeAndReturnKey(params);
        return String.valueOf(personId);
    }

    @Override
    public Optional<Person> findPersonByDocument(String personDocument) {
        Person person;
        try {
            person = jdbcTemplate.query(FIND_PERSON_BY_DOCUMENT, new Object[]{personDocument}, personRowMapper).get(0);
        } catch (IndexOutOfBoundsException e){
            person = null;
        }
        return Optional.ofNullable(person);
    }

    @Override
    public Optional<Person> findPersonByEmail(String email) {
        Person person;
        try {
            person = jdbcTemplate.query(FIND_PERSON_BY_EMAIL, new Object[]{email}, personRowMapper).get(0);
        } catch (IndexOutOfBoundsException e){
            person = null;
        }
        return Optional.ofNullable(person);
    }
}
