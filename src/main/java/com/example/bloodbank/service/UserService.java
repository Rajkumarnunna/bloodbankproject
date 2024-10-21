package com.example.bloodbank.service;

import com.example.bloodbank.dto.UserDTO;
import com.example.bloodbank.entity.User;
import com.example.bloodbank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;  // Inject PasswordEncoder

    @Autowired
    public UserService(UserRepository userRepository, 
                       AuthenticationManager authenticationManager, 
                       PasswordEncoder passwordEncoder) {  // Constructor injection
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(User user) {
        // Check if username already exists
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }
        // Hash the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public UserDTO getUserById(Long id) {
        // Find the user by ID and map to DTO
        User user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));
        return mapToDTO(user);
    }

    public boolean login(String username, String password) {
        try {
            // Authenticate user
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
            );
            return authentication.isAuthenticated();
        } catch (AuthenticationException e) {
            return false;  // Return false if authentication fails
        }
    }

    private UserDTO mapToDTO(User user) {
        // Map User entity to UserDTO
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setBloodGroup(user.getBloodGroup());
        dto.setCity(user.getCity());
        dto.setRole(user.getRole());
        dto.setUsername(user.getUsername());
        // Password not included in DTO for security reasons
        return dto;
    }
}
