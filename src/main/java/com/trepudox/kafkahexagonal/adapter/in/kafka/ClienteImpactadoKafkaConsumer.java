package com.trepudox.kafkahexagonal.adapter.in.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trepudox.kafkahexagonal.application.dto.ClienteImpactadoMessageDTO;
import com.trepudox.kafkahexagonal.application.exception.ClienteImpactadoParseException;
import com.trepudox.kafkahexagonal.application.port.in.ClienteImpactadoInputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ClienteImpactadoKafkaConsumer {

    private final ClienteImpactadoInputPort clienteImpactadoInputPort;

    // https://developer.confluent.io/quickstart/kafka-docker/
    @KafkaListener(topics = "${kafka.topic.name}")
    public void listen(ConsumerRecord<String, String> payload, Acknowledgment ack) {
        String jsonMessage = payload.value();
        log.info("Message from Kafka: {}", jsonMessage);

        try {
            ClienteImpactadoMessageDTO messageDTO = new ObjectMapper().readValue(jsonMessage, ClienteImpactadoMessageDTO.class);
            clienteImpactadoInputPort.save(messageDTO);
            ack.acknowledge();
        } catch(JsonProcessingException e) {
            throw new ClienteImpactadoParseException("Nao foi possivel converter a mensagem recebida", e);
        }

    }

}
