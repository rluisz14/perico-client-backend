package pe.perico.client.backend.db;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pe.perico.client.backend.db.rowmapper.SupplyRowMapper;
import pe.perico.client.backend.domain.Supply;

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

    private static final String FIND_ALL_SUPPLIES = "SELECT * FROM [Business].[Supply]";
    private static final String FIND_SUPPLY_BY_SUPPLY_ID = "SELECT * FROM [Business].[Supply] WHERE [supplyId] = ? AND [supplyStatus] = 'A'";
    private static final String UPDATE_STOCK_FOR_SUPPLY = "UPDATE [Business].[Supply] SET [supplyStock] = ? WHERE [supplyId] = ?";

    @Override
    public List<Supply> findAllSupplies() {
        return jdbcTemplate.query(FIND_ALL_SUPPLIES, new Object[]{}, supplyRowMapper);
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
