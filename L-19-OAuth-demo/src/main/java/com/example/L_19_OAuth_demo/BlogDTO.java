package com.example.L_19_OAuth_demo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BlogDTO {

    private Long id;

    private String title;

    private String body;

    private Date serverDateTime;


}
