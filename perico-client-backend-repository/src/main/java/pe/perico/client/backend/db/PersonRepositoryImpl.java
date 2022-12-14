package pe.perico.client.backend.db;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import pe.perico.client.backend.domain.Person;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rluisz14  on 08/10/2022
 */

@Slf4j
@Repository
@AllArgsConstructor
public class PersonRepositoryImpl implements PersonRepository {

    private final JdbcTemplate jdbcTemplate;

    private static final String TBL_PERSON = "[Person]";
    private static final String SCHEMA_BUSINESS = "[Business]";

    @Override
    public String savePerson(Person person) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withSchemaName(SCHEMA_BUSINESS)
                .withTableName(TBL_PERSON)
                .usingColumns("personDocument", "personName", "personPhoneNumber",
                        "personAddress", "personAddressReference", "personBirthday")
                .usingGeneratedKeyColumns("orderId");
        Map<String, Object> params = new HashMap<>();
        params.put("personDocument", person.getPersonDocument());
        params.put("personName", person.getPersonName());
        params.put("personPhoneNumber", person.getPersonPhoneNumber());
        params.put("personAddress", person.getPersonAddress());
        params.put("personAddressReference", person.getPersonAddressReference());
        params.put("personBirthday", person.getPersonBirthday());
        Number personId = simpleJdbcInsert.executeAndReturnKey(params);
        return String.valueOf(personId);
    }
}
