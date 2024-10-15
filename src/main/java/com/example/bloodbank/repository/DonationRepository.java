package com.example.bloodbank.repository;

import com.example.bloodbank.entities.BloodDonation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationRepository extends JpaRepository<BloodDonation, Long> {
    // Custom query methods, if necessary
}
