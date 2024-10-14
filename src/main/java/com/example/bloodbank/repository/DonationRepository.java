package com.example.bloodbank.repository;

import com.example.bloodbank.entities.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationRepository extends JpaRepository<Donation, Long> {
    // Custom query methods, if necessary
}
