package com.example.L10_SpringController_Annotation_Lombok_demo;


import lombok.*;

@Data
@AllArgsConstructor
//@Getter
//@Setter
//@ToString
//@NoArgsConstructor
//@AllArgsConstructor
public class Person {
    private Long id;
    private Integer age;
    private String name;

}
