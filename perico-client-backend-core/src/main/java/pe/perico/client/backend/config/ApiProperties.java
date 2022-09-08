package pe.perico.client.backend.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author rzenteno on 15/05/2020
 * @project mdp-xpay-tokenpay
 */
@Data
@ConfigurationProperties("perico.client.backend.apis")
public class ApiProperties {

    private Configuration configuration;

    @Data
    public static class Configuration {
    }

}
