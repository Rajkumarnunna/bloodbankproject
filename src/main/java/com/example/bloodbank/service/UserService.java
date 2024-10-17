package com.example.bloodbank.service;

import com.example.bloodbank.dto.UserDTO;
import com.example.bloodbank.entity.User;
import com.example.bloodbank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User registerUser(User user) {
        // Encrypt password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public boolean authenticate(String email, String password) {
        User user = (User) userRepository.findAll(); // Assume you have a method to find user by email
        return user != null && passwordEncoder.matches(password, user.getPassword()); // Compare hashed passwords
    }

	public UserDTO getUserById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
