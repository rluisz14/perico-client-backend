package pe.perico.client.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PericoBackendServiceConfiguration {

    @Bean
    public Service service() {
        return new Service("PericoBackend");
    }
}
