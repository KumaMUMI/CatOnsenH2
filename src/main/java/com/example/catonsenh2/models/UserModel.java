package com.example.catonsenh2.models;

import jakarta.persistence.*;

@Entity
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false)
    Long id;

    @Column(name = "Email",nullable = false)
    String email;

    @Column(name = "Tel",length = 10,nullable = false)
    String tel;
}
