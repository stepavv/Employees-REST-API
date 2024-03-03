package com.skor.employees.controller;

import com.skor.employees.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
    @Autowired
    private KafkaProducer producer;


    @PostMapping("/messages")
    public String sendMessage(@RequestBody String message) {
        producer.sendMessage(message);
        return "--Success--";
    }
}
