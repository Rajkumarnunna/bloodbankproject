package com.example.bloodbank.service; // Updated package to service

import com.example.bloodbank.entities.BloodRequest;
import com.example.bloodbank.repository.BloodRequestRepository; // Updated package
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BloodRequestService {

    @Autowired
    private BloodRequestRepository bloodRequestRepository; // Injecting the repository

    // Method to get all blood requests
    public List<BloodRequest> getAllRequests() {
        return bloodRequestRepository.findAll();
    }

    // Method to create a new blood request
    public BloodRequest createRequest(BloodRequest request) {
        return bloodRequestRepository.save(request);
    }
}
