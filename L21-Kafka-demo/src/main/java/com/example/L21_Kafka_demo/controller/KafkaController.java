package com.example.L21_Kafka_demo.controller;

import com.example.L21_Kafka_demo.dto.EmailRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private JavaMailSender javaMailSender;


    private static final Logger LOGGER =
            LoggerFactory.getLogger(KafkaController.class);

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public KafkaController(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/push")
    public ResponseEntity<String> pushDataToKafka(
            @RequestParam String topic,
            @RequestParam String data
    ) throws ExecutionException, InterruptedException {

        var future = kafkaTemplate.send(topic, data);
        LOGGER.info("Data pushed to kafka: {}", future.get());

        return ResponseEntity.ok("Data pushed to kafka successfully");
    }


    @PostMapping("/sendEmail")
    ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailRequest){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("mishraaditya6001@gmail.com");
        simpleMailMessage.setSubject(emailRequest.getSubject());
        simpleMailMessage.setTo(emailRequest.getToEmail());
        simpleMailMessage.setText(emailRequest.getBody());
        simpleMailMessage.setCc(emailRequest.getCc());
        javaMailSender.send(simpleMailMessage);
        return ResponseEntity.ok("Email Sent");

    }

    @PostMapping("/sendEmailAsync")
    ResponseEntity<String> sendEmailAsync(@RequestBody EmailRequest emailRequest) throws ExecutionException, InterruptedException {
        Future future = kafkaTemplate.send("EmailToSend",emailRequest.getToEmail(),emailRequest);
        LOGGER.info("Payload pushed to kafka : {}",future.get());
        return ResponseEntity.ok("Email Send Successfully");

    }

}

//1:44