package com.example.p3.Entity;

import java.util.List;

import org.hibernate.annotations.GenericGenerator;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Data
@Entity(name = "U_User")
public class User {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(length = 36, nullable = false, updatable = false)
    private String id; 

    @Column(name="email" , nullable = false , unique = true, length = 60) 
    private String email;

    @JsonIgnore
    @Column(name="password" , nullable = false)
    private String password;

    @Column(name="name" ,nullable = false)
    private String name;

    private String civiId;

    @OneToOne(mappedBy = "user",orphanRemoval = true,fetch = FetchType.EAGER) 
    private Social social;
    
    @OneToMany(mappedBy = "user", orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Address> address;
}
