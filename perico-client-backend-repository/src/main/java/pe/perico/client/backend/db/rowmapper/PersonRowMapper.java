package pe.perico.client.backend.db.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pe.perico.client.backend.domain.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author rluisz14  on 08/10/2022
 */
@Component
public class PersonRowMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet rs, int i) throws SQLException {
        return Person.builder()
                .personId(rs.getLong("personId"))
                .personDocument(rs.getString("personDocument"))
                .personName(rs.getString("personName"))
                .personPhoneNumber(rs.getString("personPhoneNumber"))
                .personAddress(rs.getString("personAddress"))
                .personAddressReference(rs.getString("personAddressReference"))
                .personBirthdate(rs.getString("personBirthdate"))
                .personEmail(rs.getString("personEmail"))
                .build();
    }
}
