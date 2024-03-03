package com.skor.employees.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    @Autowired
    private final KafkaTemplate<String, String> template;


    public KafkaProducer(KafkaTemplate<String, String> template) {
        this.template = template;
    }


    public void sendMessage(String message) {
        template.send("topic1", message);
    }
}
