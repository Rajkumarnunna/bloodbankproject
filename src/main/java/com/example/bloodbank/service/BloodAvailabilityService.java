package com.example.bloodbank.service;

import com.example.bloodbank.model.BloodAvailability;
import com.example.bloodbank.repository.BloodAvailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BloodAvailabilityService {

 @Autowired
 private BloodAvailabilityRepository bloodAvailabilityRepository;

 public List<BloodAvailability> findByBloodGroupAndCity(String bloodGroup, String city) {
     return bloodAvailabilityRepository.findByBloodGroupAndCity(bloodGroup, city);
 }
}
