package pe.perico.client.backend.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.perico.client.backend.controller.web.dto.PriceDetailsRequestWebDto;
import pe.perico.client.backend.controller.web.dto.PriceDetailsResponseWebDto;
import pe.perico.client.backend.controller.web.dto.ProductOrderRequestWebDto;
import pe.perico.client.backend.db.DiscountRepository;
import pe.perico.client.backend.domain.Discount;
import pe.perico.client.backend.domain.PriceDetails;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class PriceDetailsServiceImpl implements PriceDetailsService {

    private final DiscountRepository discountRepository;

    @Override
    public PriceDetailsResponseWebDto getPriceDetails(PriceDetailsRequestWebDto requestWebDto) {

        if (requestWebDto.getProducts().isEmpty()) {
            return new PriceDetailsResponseWebDto();
        }

        List<Discount> discounts = new ArrayList<>();
        for (ProductOrderRequestWebDto product : requestWebDto.getProducts()) {
            Discount discount = discountRepository.findDiscountByCategory(product.getCategoryId());
            if (discount != null) {
                discounts.add(discount);
            }
        }

        List<Double> productPrices = new ArrayList<>();
        requestWebDto.getProducts().forEach(p -> productPrices.add(p.getProductPrice()));

        List<Double> discountPercentages = new ArrayList<>();
        discounts.forEach(d -> discountPercentages.add(d.getDiscountPercentage()));

        Iterator<Double> i = productPrices.iterator();
        Double productsPrice = i.next();
        while (i.hasNext()) {
            Double next = i.next();
            productsPrice = productsPrice + next;
        }

        Double mayorDiscount = discountPercentages.isEmpty()? 0.00 : Collections.max(discountPercentages);
        Double calculatedDiscount = productsPrice * (mayorDiscount / 100);
        Double calculatedIGV = productsPrice * (18.00 / 100);
        Double deliveryCost = 5.00;
        Double total = productsPrice + calculatedIGV - calculatedDiscount + deliveryCost;

        PriceDetailsResponseWebDto priceDetailsResponseWebDto = new PriceDetailsResponseWebDto();
        PriceDetails priceDetails = PriceDetails.builder()
                .subTotal(productsPrice)
                .igv(calculatedIGV)
                .discount(calculatedDiscount)
                .deliveryCost(deliveryCost)
                .total(total)
                .build();
        priceDetailsResponseWebDto.setPriceDetails(priceDetails);
        return priceDetailsResponseWebDto;
    }

}
