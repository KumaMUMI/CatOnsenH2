package com.example.catonsenh2.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "Customer")
@Data
@NoArgsConstructor
@JsonIdentityInfo(scope = UserModel.class,generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class UserModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;

    @Column(name = "Email",nullable = false)
    private String email;

    @Column(name = "Tel",length = 10,nullable = false)
    private String tel;

    @Column(name = "Name",nullable = false)
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "IdentityAppoint",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "appoint_id")
    )
    private AppointmentModel appointment;
}
