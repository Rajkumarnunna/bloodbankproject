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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getDonor() {
		return donor;
	}
	public void setDonor(User donor) {
		this.donor = donor;
	}
	public Date getTimeOfDonation() {
		return timeOfDonation;
	}
	public void setTimeOfDonation(Date timeOfDonation) {
		this.timeOfDonation = timeOfDonation;
	}
	public double getBloodGlucoseLevel() {
		return bloodGlucoseLevel;
	}
	public void setBloodGlucoseLevel(double bloodGlucoseLevel) {
		this.bloodGlucoseLevel = bloodGlucoseLevel;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

    // Getters and Setters
}
