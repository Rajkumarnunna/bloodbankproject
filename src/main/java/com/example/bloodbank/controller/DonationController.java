package com.example.bloodbank.controller;


import com.example.bloodbank.dto.DonationRequestDTO;
import com.example.bloodbank.entity.BloodDonation;
import com.example.bloodbank.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/donations")
public class DonationController {
    
    @Autowired
    private DonationService donationService;

    @PostMapping
    public ResponseEntity<BloodDonation> recordDonation(@RequestBody DonationRequestDTO donationRequestDTO) {
        BloodDonation donation = donationService.recordDonation(donationRequestDTO);
        return ResponseEntity.ok(donation);
    }
}
