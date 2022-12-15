package pe.perico.client.backend.db;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pe.perico.client.backend.db.rowmapper.SupplyRowMapper;
import pe.perico.client.backend.db.rowmapper.SupplyViewRowMapper;
import pe.perico.client.backend.domain.Supply;
import pe.perico.client.backend.domain.SupplyView;

import java.util.List;
import java.util.Optional;

/**
 * @author rluisz14  on 08/10/2022
 */

@Slf4j
@Repository
@AllArgsConstructor
public class SupplyRepositoryImpl implements SupplyRepository {

    private final JdbcTemplate jdbcTemplate;
    private final SupplyRowMapper supplyRowMapper;
    private final SupplyViewRowMapper supplyViewRowMapper;

    private static final String FIND_ALL_SUPPLIES = "SELECT s.[supplyId],p.[providerName],s.[supplyName],s.[metricUnits],s.[supplyCost],s.[supplyStock],s.[supplyRegisterDate],s.[supplyStatus] FROM [Business].[Supply] s INNER JOIN [Business].[Provider] p ON s.providerId = p.providerId";
    private static final String FIND_SUPPLY_BY_SUPPLY_ID = "SELECT * FROM [Business].[Supply] WHERE [supplyId] = ? AND [supplyStatus] = 'A'";
    private static final String UPDATE_STOCK_FOR_SUPPLY = "UPDATE [Business].[Supply] SET [supplyStock] = ? WHERE [supplyId] = ?";

    @Override
    public List<SupplyView> findAllSupplies() {
        return jdbcTemplate.query(FIND_ALL_SUPPLIES, new Object[]{}, supplyViewRowMapper);
    }

    @Override
    public Optional<Supply> findSupplyBySupplyId(Long supplyId) {
        Supply supply;
        try {
            supply = jdbcTemplate.query(FIND_SUPPLY_BY_SUPPLY_ID, new Object[]{supplyId}, supplyRowMapper).get(0);
        } catch (IndexOutOfBoundsException e){
            supply = null;
        }
        return Optional.ofNullable(supply);
    }

    @Override
    public void updateSupplyStock(Long supplyId, Double supplyStock) {
        jdbcTemplate.update(UPDATE_STOCK_FOR_SUPPLY, supplyStock, supplyId);

    }
}
