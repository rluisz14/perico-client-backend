package pe.perico.client.backend.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.perico.client.backend.controller.web.dto.ListSupplyResponseWebDto;
import pe.perico.client.backend.db.SupplyRepository;

@Slf4j
@AllArgsConstructor
@Service
public class SupplyServiceImpl implements SupplyService {

    private final SupplyRepository supplyRepository;

    @Override
    public ListSupplyResponseWebDto getSupplies() {
        ListSupplyResponseWebDto listSupplyResponseWebDto = new ListSupplyResponseWebDto();
        listSupplyResponseWebDto.setSupplies(supplyRepository.findAllSupplies());
        return listSupplyResponseWebDto;
    }
}
