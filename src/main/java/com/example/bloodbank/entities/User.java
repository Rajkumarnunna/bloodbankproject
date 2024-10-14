package com.example.bloodbank.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String bloodGroup;
    private String city;
    private String role; // e.g., Admin, Donor, Requestor

    // Getters and Setters
}
