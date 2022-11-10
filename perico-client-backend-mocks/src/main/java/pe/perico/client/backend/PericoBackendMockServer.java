package pe.perico.client.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author rzenteno on 21/05/2020
 * @project perico-client-backend
 */
@SpringBootApplication(scanBasePackages = "pe.perico")
public class PericoBackendMockServer {
    public static void main(String []args) {
        SpringApplication.run(PericoBackendMockServer.class, args);
    }
}
