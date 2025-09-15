package com.example.springboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

//@Table(name = "member", uniqueConstraints = {
//        @UniqueConstraint(columnNames = "email")
//}) s another way (useful if you want multiple columns unique together
@Entity
@Data               // generates getters, setters, toString, equals, hashCode
@NoArgsConstructor  // generates the default constructor
@AllArgsConstructor // generates a constructor with all fields
@Builder
public class Member {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}