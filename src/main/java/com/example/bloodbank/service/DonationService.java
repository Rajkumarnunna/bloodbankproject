package com.example.bloodbank.service;

import com.example.bloodbank.dto.DonationRequestDTO;
import com.example.bloodbank.entity.BloodDonation;
import com.example.bloodbank.exception.ResourceNotFoundException;
import com.example.bloodbank.repository.DonationRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DonationService {

    @Autowired
    private DonationRequestRepository donationRequestRepository;

    public BloodDonation donateBlood(DonationRequestDTO donationRequestDTO) {
        BloodDonation bloodDonation = new BloodDonation();
        bloodDonation.setPatientName(donationRequestDTO.getPatientName());
        bloodDonation.setBloodGroup(donationRequestDTO.getBloodGroup());
        bloodDonation.setCity(donationRequestDTO.getCity());

        return donationRequestRepository.save(bloodDonation);
    }

    public String getDonationStatus(Long id) {
        Optional<BloodDonation> donation = donationRequestRepository.findById(id);
        if (donation.isPresent()) {
            return donation.get().getStatus();  // Assuming BloodDonation has a getStatus() method
        } else {
            throw new ResourceNotFoundException("Donation not found");
        }
    }
}
