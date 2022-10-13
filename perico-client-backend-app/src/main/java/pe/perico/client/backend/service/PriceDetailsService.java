package pe.perico.client.backend.service;

import pe.perico.client.backend.controller.web.dto.PriceDetailsRequestWebDto;
import pe.perico.client.backend.controller.web.dto.PriceDetailsResponseWebDto;

/**
 * @author rluisz14  on 08/10/2022
 */
public interface PriceDetailsService {

    PriceDetailsResponseWebDto getPriceDetails(PriceDetailsRequestWebDto requestWebDto);
}
