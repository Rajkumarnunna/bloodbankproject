package com.example.bloodbank.service;

import com.example.bloodbank.dto.DonationRequestDTO;
import com.example.bloodbank.entity.BloodDonation;
import java.util.List;

public interface DonationService {
    BloodDonation donateBlood(DonationRequestDTO donationRequestDTO); // Accepts DTO, returns entity
    String getDonationStatus(Long id); // Returns a status message
    List<DonationRequestDTO> getAllDonations(); // Returns a list of DTOs for all donations
}
