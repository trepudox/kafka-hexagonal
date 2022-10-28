package com.trepudox.kafkahexagonal.adapter.in.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaConsumer {

    // https://developer.confluent.io/quickstart/kafka-docker/
    @KafkaListener(topics = "${kafka.topic.name}")
    public void listen(String message) {
        System.out.println("Message from Kafka: " + message);
    }

}
