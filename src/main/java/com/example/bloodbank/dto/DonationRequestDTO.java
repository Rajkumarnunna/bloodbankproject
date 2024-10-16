package com.example.bloodbank.dto;

import java.time.LocalDateTime;

public class DonationRequestDTO {
    private Long userId;
    private LocalDateTime donationDate;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public LocalDateTime getDonationDate() {
		return donationDate;
	}
	public void setDonationDate(LocalDateTime donationDate) {
		this.donationDate = donationDate;
	}

  
}
