package com.example.bloodbank.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "donations")
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "donor_id")
    private User donor;

    private Date timeOfDonation;
    private double bloodGlucoseLevel;
    private String notes;
    private String status; // e.g., Pending, Accepted, Rejected

    // Getters and Setters
}
