package com.example.springboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

//@Table(name = "member", uniqueConstraints = {
//        @UniqueConstraint(columnNames = "email")
//}) s another way (useful if you want multiple columns unique together
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"password"})
@EqualsAndHashCode(exclude = {"password"})
public class Member {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;
}