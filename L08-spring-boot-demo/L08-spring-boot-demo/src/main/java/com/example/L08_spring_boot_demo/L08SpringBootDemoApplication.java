package com.example.L08_spring_boot_demo;

import org.example.DefaultKeywordAnalyzer;
import org.example.KeywordAnalyzerInterface;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class L08SpringBootDemoApplication {

//	@Bean
//	public KeywordAnalyzerInterface defaultKeywordAnalyzer() {
//		return new DefaultKeywordAnalyzer();
//	}

	public static void main(String[] args) {
		SpringApplication.run(L08SpringBootDemoApplication.class, args);
	}

}
