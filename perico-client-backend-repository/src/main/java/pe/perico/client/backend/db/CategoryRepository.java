package pe.perico.client.backend.db;

import pe.perico.client.backend.domain.Category;

import java.util.List;
import java.util.Optional;

/**
 * @author rluisz14  on 08/10/2022
 */
public interface CategoryRepository {

    Optional<Category> findCategoryById(String categoryId);
    List<Category> findAllCategories();
    String registerCategory(Category category);
    String updateCategory(Category category);
    String deleteCategory(Long categoryId);
}
