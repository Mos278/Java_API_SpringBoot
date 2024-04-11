package com.example.p3.Entity;


import org.hibernate.annotations.GenericGenerator;


import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity(name = "Address")
public class Address {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(length = 36, nullable = false, updatable = false)
    private String id; 
    

    @Column(name = "line1" , length = 120)
    private String line1;

    @Column(name = "line2" , length = 120)
    private String line2;

    @Column(name = "zipcode" , length = 120)
    private String zipcode;

    @ManyToOne
    @JoinColumn(name="fk_Ad_user",nullable = false)
    private User user;
}
