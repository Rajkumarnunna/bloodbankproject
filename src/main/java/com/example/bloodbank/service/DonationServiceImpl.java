package com.example.bloodbank.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.bloodbank.dto.DonationRequestDTO;
import com.example.bloodbank.entity.BloodDonation;
import com.example.bloodbank.repository.DonationRequestRepository;

@Service
public class DonationServiceImpl implements DonationService {

    private final DonationRequestRepository donationRequestRepository;

    // Constructor-based injection
    public DonationServiceImpl(DonationRequestRepository donationRequestRepository) {
        this.donationRequestRepository = donationRequestRepository;
    }

    @Override
    public BloodDonation donateBlood(DonationRequestDTO donationRequestDTO) {
        // Create a new BloodDonation entity using the donor's information from DTO
        BloodDonation bloodDonation = new BloodDonation();
        bloodDonation.setDonorName(donationRequestDTO.getDonorName()); // Set donor's name
        bloodDonation.setBloodGroup(donationRequestDTO.getBloodGroup()); // Set blood group
        bloodDonation.setCity(donationRequestDTO.getCity()); // Set city
        bloodDonation.setAmount(donationRequestDTO.getAmount()); // Set donation amount
        bloodDonation.setStatus("Pending"); // Set default status for the donation
        
        // Save the blood donation in the repository
        return donationRequestRepository.save(bloodDonation); // Mock saving operation
    }

    @Override
    public String getDonationStatus(Long id) {
        // Fetch donation status by ID
        BloodDonation donation = donationRequestRepository.findById(id).orElse(null);
        if (donation != null) {
            return "Donation status for ID " + id + ": " + donation.getStatus();
        } else {
            return "Donation with ID " + id + " not found.";
        }
    }

    @Override
    public List<DonationRequestDTO> getAllDonations() {
        // Retrieve all donations from the repository and map them to DTOs
        List<BloodDonation> donations = donationRequestRepository.findAll();
        return donations.stream().map(donation -> {
            DonationRequestDTO dto = new DonationRequestDTO();
            dto.setDonorName(donation.getDonorName());
            dto.setBloodGroup(donation.getBloodGroup());
            dto.setCity(donation.getCity());
            dto.setAmount(donation.getAmount());
            return dto;
        }).collect(Collectors.toList());
    }
}
