package pe.perico.client.backend.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PriceDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Double subTotal;
    private Double igv;
    private Double discount;
    private Double deliveryCost;
    private Double total;
}
