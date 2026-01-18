package com.example.L10_SpringController_Annotation_Lombok_demo;

public class LombokDemo {
    public static void main(String[] args) {
        Person person = new Person(1L, 25, "John");
        System.out.println(person.getName());
        person.setName("Doe");

        System.out.println(person);
    }
}
