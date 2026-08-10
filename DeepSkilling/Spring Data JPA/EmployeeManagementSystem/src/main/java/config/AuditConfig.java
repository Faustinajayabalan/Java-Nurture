package config;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

@Configuration
public class AuditConfig {

    @Bean
    AuditorAware<String> auditorProvider() {

        return () -> Optional.of("CTS User");

    }

}