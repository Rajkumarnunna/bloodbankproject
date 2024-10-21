package com.example.bloodbank.controller;

import com.example.bloodbank.dto.UserDTO;
import com.example.bloodbank.entity.User;
import com.example.bloodbank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO) {
        User user = mapToUser(userDTO);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        userService.registerUser(user);
        return ResponseEntity.ok("User registered successfully.");
    }

    @GetMapping("/profile/{id}")
    public ResponseEntity<UserDTO> getUserProfile(@PathVariable Long id) {
        UserDTO userDTO = userService.getUserById(id);
        return ResponseEntity.ok(userDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody UserDTO userDTO) {
        boolean isAuthenticated = userService.login(userDTO.getUsername(), userDTO.getPassword());
        return isAuthenticated 
            ? ResponseEntity.ok("Login successful.") 
            : ResponseEntity.status(401).body("Invalid credentials.");
    }

    private User mapToUser(UserDTO userDTO) {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setBloodGroup(userDTO.getBloodGroup());
        user.setCity(userDTO.getCity());
        user.setRole(userDTO.getRole());
        user.setUsername(userDTO.getUsername());
        return user;
    }
}
