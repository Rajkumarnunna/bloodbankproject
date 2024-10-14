package com.example.bloodbank.controllers;


import com.example.bloodbank.model.BloodAvailability;
import com.example.bloodbank.service.BloodAvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BloodAvailabilityController {

 @Autowired
 private BloodAvailabilityService bloodAvailabilityService;

 @GetMapping("/api/blood-availability")
 public List<BloodAvailability> checkBloodAvailability(
         @RequestParam String bloodGroup,
         @RequestParam String city) {
     return bloodAvailabilityService.findByBloodGroupAndCity(bloodGroup, city);
 }
}
