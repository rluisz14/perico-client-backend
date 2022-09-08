package pe.perico.client.backend.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author rzenteno on 21/05/2020
 * @project mdp-xpay-tokenpay
 */
@Data
@Validated
@ConfigurationProperties("perico.client.backend")
public class MicroServiceProperties {

    @NotNull
    private Features features;

    @NotNull
    private Configuration configuration;

    @Data
    public static class Features {
        private boolean panicEnabled;
    }

    @Data
    public static class Configuration {
        @NotEmpty
        private String topUpStatement;
    }
}
