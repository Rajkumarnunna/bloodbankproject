package com.example.bloodbank.controller;

import com.example.bloodbank.dto.UserDTO;
import com.example.bloodbank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<String> loginUser(@RequestBody UserDTO userDTO) {
        // Validate login logic
        boolean isAuthenticated = userService.authenticate(userDTO.getEmail(), userDTO.getPassword());

        if (isAuthenticated) {
            // Here you can return a success message or redirect to a home page
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}
