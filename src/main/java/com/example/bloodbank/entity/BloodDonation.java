package com.example.bloodbank.entity;


import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import com.example.bloodbank.entity.User;

@Entity
public class BloodDonation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User donor;

    private LocalDateTime donationDate;

	public void setDonor(User donor2) {
		// TODO Auto-generated method stub
		
	}

	public void setDonationDate(LocalDateTime now) {
		// TODO Auto-generated method stub
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getDonor() {
		return donor;
	}

	public LocalDateTime getDonationDate() {
		return donationDate;
	}

 
}
