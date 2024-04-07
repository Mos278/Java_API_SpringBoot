package com.example.p3.Entity;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "social")
public class Social {
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(length = 36, nullable = false, updatable = false)
    private String id; 

    @Column(name="facebook"  , length = 60)
    private String facebook; 

    @Column(name="ig" ) 
    private String ig;

    @OneToOne
    @JoinColumn(name ="fk_So_user",nullable = false)
    private User user;

    
}
