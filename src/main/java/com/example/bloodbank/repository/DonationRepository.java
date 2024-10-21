package com.example.bloodbank.repository;

import com.example.bloodbank.entity.BloodDonation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationRepository extends JpaRepository<BloodDonation, Long> {
    // Additional query methods can be defined here
}
