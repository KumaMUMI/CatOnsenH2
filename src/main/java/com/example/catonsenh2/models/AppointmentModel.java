package com.example.catonsenh2.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Appointment")
@Data
@NoArgsConstructor
public class AppointmentModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private long id;

    @Column(name = "Room",nullable = false)
    private int room;

    @Column(name = "Payment",nullable = false)
    private String payment;

    @Column(name = "Date",nullable = false)
    private Date date;

}
