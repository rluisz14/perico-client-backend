package pe.perico.client.backend.db.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pe.perico.client.backend.domain.ParameterDetail;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author X10144 on 17/02/2021
 */
@Component
public class ParameterDetailRowMapper implements RowMapper<ParameterDetail> {
    @Override
    public ParameterDetail mapRow(ResultSet rs, int i) throws SQLException {
        return ParameterDetail.builder()
                .Codigo(rs.getString("Codigo"))
                .codigoParametro(rs.getString("codigoParametro"))
                .Valor(rs.getString("Valor"))
                .Descripcion(rs.getString("Descripcion"))
                .Identificador(rs.getString("Identificador"))
                .build();
    }
}
