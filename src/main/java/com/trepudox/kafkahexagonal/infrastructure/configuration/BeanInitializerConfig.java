package com.trepudox.kafkahexagonal.infrastructure.configuration;

import com.trepudox.kafkahexagonal.application.port.out.DatabaseOutputPort;
import com.trepudox.kafkahexagonal.application.service.ClienteImpactadoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanInitializerConfig {

    @Bean
    public ClienteImpactadoService clienteImpactadoService(DatabaseOutputPort databaseOutputPort) {
        return new ClienteImpactadoService(databaseOutputPort);
    }

}
