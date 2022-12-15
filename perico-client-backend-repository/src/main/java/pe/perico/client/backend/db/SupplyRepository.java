package pe.perico.client.backend.db;

import pe.perico.client.backend.domain.Supply;

import java.util.List;
import java.util.Optional;

/**
 * @author rluisz14  on 08/10/2022
 */
public interface SupplyRepository {

    List<Supply> findAllSupplies();
    Optional<Supply> findSupplyBySupplyId(Long supplyId);
    void updateSupplyStock(Long supplyId, Double supplyStock);
}
