package com.github.agrajm.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.github.agrajm.models.SimpleMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class Producer {

    private final KafkaTemplate<String, SimpleMessage> kafkaTemplate;

    @Value("${topic.name}")
    private String topicName;

    public void send(SimpleMessage message) {
        this.kafkaTemplate.send(topicName, message);
        log.info("Published the message [{}] to the kafka queue: [{}]",
                message,
                topicName
        );
    }
}
