package pe.perico.client.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author rzenteno on 15/05/2020
 * @project mdp-xpay-tokenpay
 */
@SpringBootApplication(scanBasePackages = "pe.perico.client", exclude = {DataSourceAutoConfiguration.class})
public class PericoBackendService {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(PericoBackendService.class);
        app.addListeners();
        app.run(args);
    }
}

