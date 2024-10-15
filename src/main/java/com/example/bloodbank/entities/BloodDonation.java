package com.example.bloodbank.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "blood_donations")
public class BloodDonation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String bloodGroup;
    private int unitsProvided;
    private LocalDateTime donationDate;
    private String status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public int getUnitsProvided() {
		return unitsProvided;
	}
	public void setUnitsProvided(int unitsProvided) {
		this.unitsProvided = unitsProvided;
	}
	public LocalDateTime getDonationDate() {
		return donationDate;
	}
	public void setDonationDate(LocalDateTime donationDate) {
		this.donationDate = donationDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}