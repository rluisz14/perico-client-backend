package pe.perico.client.backend.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.perico.client.backend.controller.web.dto.CategoryResponseWebDto;
import pe.perico.client.backend.db.CategoryRepository;

@Slf4j
@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryResponseWebDto getCategories() {
        CategoryResponseWebDto categoryResponseWebDto = new CategoryResponseWebDto();
        categoryResponseWebDto.setCategories(categoryRepository.findAllCategories());
        return categoryResponseWebDto;
    }

}
