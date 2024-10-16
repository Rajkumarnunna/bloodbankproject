package com.example.bloodbank.controller;

import com.example.bloodbank.dto.UserDTO;
import com.example.bloodbank.entity.User;
import com.example.bloodbank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody @Validated UserDTO userDTO) {
        // Convert UserDTO to User
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setBloodType(userDTO.getBloodGroup());
        user.setCity(userDTO.getCity());

        // Call the service to save the user
        User registeredUser = userService.registerUser(user);
        return ResponseEntity.ok(registeredUser);
    }
}
