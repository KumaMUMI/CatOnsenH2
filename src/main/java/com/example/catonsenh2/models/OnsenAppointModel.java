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

    @Column(name = "Payment",nullable = false)
    private String payment;

    @Column(name = "Date",nullable = false)
    private Date date;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "UserOnsen",
            joinColumns = @JoinColumn(name = "onsen_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private UserModel user;
}
