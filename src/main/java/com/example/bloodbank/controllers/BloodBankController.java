package com.example.bloodbank.controllers;

import com.example.bloodbank.service.BloodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/blood")
public class BloodBankController {

    private final BloodService bloodService;

    @Autowired
    public BloodBankController(BloodService bloodService) {
        this.bloodService = bloodService;
    }

    @GetMapping("/availability/{bloodType}")
    public boolean checkBloodAvailability(@PathVariable String bloodType) {
        return bloodService.checkBloodAvailability(bloodType);
    }

    @PostMapping("/register")
    public void registerUser(@RequestParam String name,
                             @RequestParam String email,
                             @RequestParam String phone,
                             @RequestParam String bloodType) {
        System.out.println("Registering user: " + name); // Debugging log
        bloodService.registerUser(name, email, phone, bloodType);
    }
}
