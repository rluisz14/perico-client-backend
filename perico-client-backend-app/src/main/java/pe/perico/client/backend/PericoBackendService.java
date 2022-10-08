package pe.perico.client.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author rluisz14  on 08/10/2022
 */
@SpringBootApplication(scanBasePackages = "pe.perico.client")
public class PericoBackendService {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(PericoBackendService.class);
        app.addListeners();
        app.run(args);
    }
}

