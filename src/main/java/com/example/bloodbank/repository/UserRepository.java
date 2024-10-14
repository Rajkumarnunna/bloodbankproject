package com.example.bloodbank.repository;

import com.example.bloodbank.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Custom query methods, if necessary
}
