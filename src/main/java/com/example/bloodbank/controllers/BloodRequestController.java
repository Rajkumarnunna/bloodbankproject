package com.example.bloodbank.controllers;

import com.example.bloodbank.entities.BloodRequest;
import com.example.bloodbank.service.BloodRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests") // Base URL for blood request endpoints
public class BloodRequestController {

    @Autowired
    private BloodRequestService bloodRequestService; // Injecting the BloodRequestService

    // Endpoint to get all blood requests
    @GetMapping
    public List<BloodRequest> getAllRequests() {
        return bloodRequestService.getAllRequests();
    }

    // Endpoint to create a new blood request
    @PostMapping
    public BloodRequest createRequest(@RequestBody BloodRequest request) {
        return bloodRequestService.createRequest(request);
    }
}
