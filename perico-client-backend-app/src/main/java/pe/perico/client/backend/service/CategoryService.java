package pe.perico.client.backend.service;

import pe.perico.client.backend.controller.web.dto.CategoryResponseWebDto;

/**
 * @author rluisz14  on 08/10/2022
 */
public interface CategoryService {

    CategoryResponseWebDto getCategories();
}
