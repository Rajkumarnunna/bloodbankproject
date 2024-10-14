package com.example.bloodbank.repository; // Updated package

import com.example.bloodbank.entities.BloodRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodRequestRepository extends JpaRepository<BloodRequest, Long> {
    // Additional query methods can be defined here if needed
}
