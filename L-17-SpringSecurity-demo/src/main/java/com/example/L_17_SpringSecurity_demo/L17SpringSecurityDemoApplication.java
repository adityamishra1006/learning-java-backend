package com.example.L_17_SpringSecurity_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableRedisHttpSession
public class L17SpringSecurityDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(L17SpringSecurityDemoApplication.class, args);
	}

}
