package com.example.bloodbank.controller;

import com.example.bloodbank.dto.DonationRequestDTO;
import com.example.bloodbank.entity.BloodDonation;
import com.example.bloodbank.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/donation")
public class DonationController {

    @Autowired
    private DonationService donationService;

    @PostMapping("/donate")
    public ResponseEntity<BloodDonation> donate(@RequestBody DonationRequestDTO donationRequestDTO) {
        BloodDonation donation = donationService.donateBlood(donationRequestDTO);
        return ResponseEntity.ok(donation);
    }

    @GetMapping("/status/{id}")
    public ResponseEntity<String> getDonationStatus(@PathVariable Long id) {
        String status = donationService.getDonationStatus(id);
        return ResponseEntity.ok(status);
    }

    @GetMapping("/all")
    public ResponseEntity<List<DonationRequestDTO>> getAllDonations() {
        List<DonationRequestDTO> donations = donationService.getAllDonations();
        return ResponseEntity.ok(donations);
    }
}
