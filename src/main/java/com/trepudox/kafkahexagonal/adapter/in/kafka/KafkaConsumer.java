package com.trepudox.kafkahexagonal.adapter.in.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trepudox.kafkahexagonal.application.dto.ClienteImpactadoMessageDTO;
import com.trepudox.kafkahexagonal.application.exception.ClienteImpactadoParseException;
import com.trepudox.kafkahexagonal.application.port.in.ClienteImpactadoInputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaConsumer {

    private final ClienteImpactadoInputPort clienteImpactadoInputPort;

    // https://developer.confluent.io/quickstart/kafka-docker/
    // {"data":"30/10/2022 13:10","app":"Itau Personnalite","clientes":"100","impactados":"20","altaPrioridade":"5","baixaPrioridade":"15"}
//    @KafkaListener(topics = "${kafka.topic.name}")
    public void listen(String message, Acknowledgment ack) {
        log.info("Message from Kafka: " + message);

        try {
            ClienteImpactadoMessageDTO messageDTO = new ObjectMapper().readValue(message, ClienteImpactadoMessageDTO.class);
            clienteImpactadoInputPort.save(messageDTO);
        } catch(JsonProcessingException e) {
            throw new ClienteImpactadoParseException("Nao foi possivel converter a mensagem recebida", e);
        }

        ack.acknowledge();
    }

}
