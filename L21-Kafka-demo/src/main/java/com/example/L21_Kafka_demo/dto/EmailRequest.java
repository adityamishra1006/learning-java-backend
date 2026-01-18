package com.example.L21_Kafka_demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class EmailRequest {
    private String toEmail;
    private String subject;
    private String body;
    private String cc;
}
