package pe.perico.client.backend.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * @author rluisz14 on 08/10/2022
 */
@Data
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long orderId;
    private Long employeeUserId;
    private Long clientUserId;
    private Long offerId;
    private ZonedDateTime orderDate;
    private ZonedDateTime orderDeliveredDate;
    private String orderStatus;
    private Double subtotal;
    private Double igv;
    private Double deliveryCost;
    private Double total;
}
