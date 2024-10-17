package com.example.bloodbank.controller;

import com.example.bloodbank.dto.DonationRequestDTO;
import com.example.bloodbank.service.DonationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/donation")
public class DonationController {

    private final DonationService donationService;

    public DonationController(DonationService donationService) {
        this.donationService = donationService;
    }

    @PostMapping("/donate")
    public ResponseEntity<String> donateBlood(@RequestBody DonationRequestDTO donationRequestDTO) {
        donationService.donateBlood(donationRequestDTO);
        return ResponseEntity.ok("Blood donation request submitted.");
    }

    @GetMapping("/status/{id}")
    public ResponseEntity<String> getDonationStatus(@PathVariable Long id) {
        String status = donationService.getDonationStatus(id);
        return ResponseEntity.ok(status);
    }
}
