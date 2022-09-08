package pe.perico.client.backend.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

/**
 * @author rzenteno on 21/05/2020
 * @project mdp-xpay-tokenpay
 */
@Data
@Validated
@ConfigurationProperties("mdp.xpay.manager.events")
public class EventsProperties {
}
