package com.example.menu.user;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Users")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID )

    private UUID id;
    
    @Column (name = "NAME", nullable = false ) 
    private String name;

    @Column (name = "PASSWORD", nullable = false)
    private Integer password;

    @Column (name = "FIRST_NAME", nullable = false)
    private String firtsName;

    @Column (name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column (name = "EMAIL", nullable = false)
    private String email;



}
