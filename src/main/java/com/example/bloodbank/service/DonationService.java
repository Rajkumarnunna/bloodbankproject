package com.example.bloodbank.service;

import com.example.bloodbank.dto.DonationRequestDTO;
import com.example.bloodbank.entity.BloodDonation;
import com.example.bloodbank.entity.User;
import com.example.bloodbank.repository.DonationRequestRepository;
import com.example.bloodbank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DonationService {
    
    @Autowired
    private DonationRequestRepository donationRequestRepository;

    @Autowired
    private UserRepository userRepository;

    public BloodDonation recordDonation(DonationRequestDTO donationRequestDTO) {
        User donor = userRepository.findById(donationRequestDTO.getUserId())
                .orElseThrow();
        
        BloodDonation donation = new BloodDonation();
        donation.setDonor(donor);
        donation.setDonationDate(LocalDateTime.now());
        
        return donationRequestRepository.save(donation);
    }
}
