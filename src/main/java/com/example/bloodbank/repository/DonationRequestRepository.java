package com.example.bloodbank.repository;

import com.example.bloodbank.entity.BloodDonation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationRequestRepository extends JpaRepository<BloodDonation, Long> {
}
