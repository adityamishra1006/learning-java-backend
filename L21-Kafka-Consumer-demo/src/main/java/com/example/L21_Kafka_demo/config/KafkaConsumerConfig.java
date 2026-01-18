package com.example.L21_Kafka_demo.config;

import com.example.L21_Kafka_demo.dto.EmailRequest;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import tools.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Configuration
public class KafkaConsumerConfig {

    @Autowired
    private JavaMailSender javaMailSender;

    private ObjectMapper objectMapper = new ObjectMapper();

    private static Logger LOGGER = org.slf4j.LoggerFactory.getLogger(KafkaConsumerConfig.class);

    @KafkaListener(topics = "jbdlpar2", groupId = "app1")
    public void consumeData(Object payload){
        String data = (String) ((ConsumerRecord) payload).value();
        LOGGER.info("Data consuming payload: {}", payload);
        LOGGER.info("Data consuming value: {}", data);
    }

    @KafkaListener(topics = "EmailToSend", groupId = "app1")
    public void emailToSend(Object payload){
        String jsonValue = (String) ((ConsumerRecord) payload).value();
        EmailRequest emailRequest = objectMapper.readValue(jsonValue, EmailRequest.class);

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("mishraaditya6001@gmail.com");
        simpleMailMessage.setSubject(emailRequest.getSubject());
        simpleMailMessage.setTo(emailRequest.getToEmail());
        simpleMailMessage.setText(emailRequest.getBody());
        simpleMailMessage.setCc(emailRequest.getCc());
        javaMailSender.send(simpleMailMessage);


        LOGGER.info("Email sent to : {}", emailRequest.getToEmail());
    }


}
