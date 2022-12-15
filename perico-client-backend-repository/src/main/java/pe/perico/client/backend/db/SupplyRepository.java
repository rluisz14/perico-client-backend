package pe.perico.client.backend.db;

import pe.perico.client.backend.domain.Supply;
import pe.perico.client.backend.domain.SupplyView;

import java.util.List;
import java.util.Optional;

/**
 * @author rluisz14  on 08/10/2022
 */
public interface SupplyRepository {

    List<SupplyView> findAllSupplies();
    Optional<Supply> findSupplyBySupplyId(Long supplyId);
    void updateSupplyStock(Long supplyId, Double supplyStock);
}
