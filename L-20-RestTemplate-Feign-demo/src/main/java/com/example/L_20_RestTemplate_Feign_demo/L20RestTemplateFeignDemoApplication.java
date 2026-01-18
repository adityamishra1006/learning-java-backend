package com.example.L_20_RestTemplate_Feign_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class L20RestTemplateFeignDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(L20RestTemplateFeignDemoApplication.class, args);
	}

}
