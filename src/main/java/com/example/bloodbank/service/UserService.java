package com.example.bloodbank.service;

import com.example.bloodbank.entity.User;
import com.example.bloodbank.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        // Perform any necessary validation, processing, or mapping
        return userRepository.save(user);
    }
}
