package com.example.L_19_OAuth_demo;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class MyUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name = "GitHub User";

    @Column(nullable = false, unique = true)
    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date lastAccess = new Date();
}
