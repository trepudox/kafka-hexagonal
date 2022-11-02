package com.trepudox.kafkahexagonal.adapter.out.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trepudox.kafkahexagonal.application.dto.ClienteImpactadoMessageDTO;
import com.trepudox.kafkahexagonal.infrastructure.generator.ClienteImpactadoGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class ClienteImpactadoKafkaProducer {

    private final KafkaProducer<String, String> kafkaProducer;
    private final ClienteImpactadoGenerator generator;

    @Value("${kafka.topic.name}")
    private String topicName;

    @Scheduled(cron = "10 0/5 * ? * *")
    public void produce() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        List<ClienteImpactadoMessageDTO> dtos = generator.createDtoList();

        for(ClienteImpactadoMessageDTO dto : dtos) {
            String json = objectMapper.writeValueAsString(dto);

            ProducerRecord<String, String> producerRecord = new ProducerRecord<>(topicName, json);

            kafkaProducer.send(producerRecord);
            log.info("Mensagem enviada: {}", producerRecord);
        }

        kafkaProducer.flush(); // pra quê?
        log.info("kafkaProducer.flush()");
    }

}
