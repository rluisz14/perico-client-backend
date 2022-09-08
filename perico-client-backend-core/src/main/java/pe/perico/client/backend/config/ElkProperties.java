package pe.perico.client.backend.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
@ConfigurationProperties("mdp.xpay.manager.elk")
public class ElkProperties{
}
