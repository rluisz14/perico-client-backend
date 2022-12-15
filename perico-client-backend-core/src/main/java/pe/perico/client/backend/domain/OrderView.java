package pe.perico.client.backend.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author rluisz14 on 08/10/2022
 */
@Data
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderView implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long orderId;
    private String clientDocumentNumber;
    private String clientName;
    private String employeeName;
    private LocalDateTime orderDate;
    private LocalDateTime orderDeliveredDate;
    private String orderStatus;
    private Double subtotal;
    private Double igv;
    private Double deliveryCost;
    private Double total;
    private String phoneNumber;
    private String email;
    private String paymentMethod;
    private String addressDelivery;
    private String addressReferenceDelivery;
}
