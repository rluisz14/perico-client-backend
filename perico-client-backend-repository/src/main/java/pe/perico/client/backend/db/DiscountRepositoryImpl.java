package pe.perico.client.backend.db;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pe.perico.client.backend.db.rowmapper.DiscountRowMapper;
import pe.perico.client.backend.domain.Discount;

import java.util.List;

/**
 * @author rluisz14  on 08/10/2022
 */

@Slf4j
@Repository
@AllArgsConstructor
public class DiscountRepositoryImpl implements DiscountRepository {

    private final JdbcTemplate jdbcTemplate;
    private final DiscountRowMapper discountRowMapper;

    private static final String TBL_DISCOUNT = "Discount";
    private static final String SCHEMA_BUSINESS = "Business";

    private static final String FIND_ALL_DISCOUNTS = "SELECT * FROM [Business].[Discount]";
    private static final String FIND_DISCOUNT_BY_CATEGORY = "SELECT * FROM [Business].[Discount] WHERE [categoryId] = ?";


    @Override
    public List<Discount> findAllDiscount() {
        return null;
    }

    @Override
    public Discount findDiscountByCategory(Long categoryId) {
        List<Discount> discounts = jdbcTemplate.query(FIND_DISCOUNT_BY_CATEGORY, new Object[]{categoryId}, discountRowMapper);
        return discounts.isEmpty()? null: discounts.get(0);
    }

    @Override
    public String registerDiscount(Discount discount) {
        return null;
    }

    @Override
    public String updateDiscount(Discount discount) {
        return null;
    }

    @Override
    public String deleteDiscount(Long orderId) {
        return null;
    }
}
