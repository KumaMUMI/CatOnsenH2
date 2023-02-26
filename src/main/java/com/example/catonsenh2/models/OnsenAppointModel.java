package com.example.catonsenh2.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "OnsenAppointment")
@Data
@NoArgsConstructor
@JsonIdentityInfo(scope = OnsenAppointModel.class,generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class OnsenAppointModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id",nullable = false)
    private long id;

    @Column(name = "Room",nullable = false)
    private int room;

    @Column(name = "Date",nullable = false)
    private Date date;

    @OneToOne(cascade = CascadeType.ALL)
    private UserModel user;

    @Column(name = "paymentImage",nullable = false)
    private String onsenImage;
}
