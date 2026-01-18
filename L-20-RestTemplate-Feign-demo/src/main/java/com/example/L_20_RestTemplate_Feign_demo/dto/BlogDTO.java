package com.example.L_20_RestTemplate_Feign_demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlogDTO {

    private Long id;

    private String title;

    private String body;

    private Date serverDateTime;


}
