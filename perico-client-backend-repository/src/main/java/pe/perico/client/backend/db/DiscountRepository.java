package pe.perico.client.backend.db;

import pe.perico.client.backend.domain.Discount;

import java.util.List;

/**
 * @author rluisz14  on 08/10/2022
 */
public interface DiscountRepository {

    List<Discount> findAllDiscount();
    Discount findDiscountByCategory(Long categoryId);
    String registerDiscount(Discount discount);
    String updateDiscount(Discount discount);
    String deleteDiscount(Long discountId);
}
