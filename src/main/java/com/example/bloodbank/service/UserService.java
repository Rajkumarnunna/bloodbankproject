package com.example.bloodbank.service;

import com.example.bloodbank.entities.User;
import com.example.bloodbank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        // Add any business logic, validation, or password encoding here
        return userRepository.save(user);
    }
}