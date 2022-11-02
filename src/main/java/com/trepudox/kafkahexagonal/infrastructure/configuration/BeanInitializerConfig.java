package com.trepudox.kafkahexagonal.infrastructure.configuration;

import com.trepudox.kafkahexagonal.application.mapper.ClienteImpactadoApplicationMapper;
import com.trepudox.kafkahexagonal.application.port.out.DatabaseOutputPort;
import com.trepudox.kafkahexagonal.application.service.ClienteImpactadoService;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class BeanInitializerConfig {

    @Bean
    public ClienteImpactadoService clienteImpactadoService(DatabaseOutputPort databaseOutputPort, ClienteImpactadoApplicationMapper clienteImpactadoApplicationMapper) {
        return new ClienteImpactadoService(databaseOutputPort, clienteImpactadoApplicationMapper);
    }

    @Bean
    public ClienteImpactadoApplicationMapper clienteImpactadoMapper() {
        return new ClienteImpactadoApplicationMapper();
    }

    @Bean
    public KafkaProducer<String, String> kafkaProducer() {
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        return new KafkaProducer<>(properties);
    }

}
