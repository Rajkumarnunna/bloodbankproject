// BloodBankController.java
package com.example.bloodbank.controller;

import com.example.bloodbank.entity.User;
import com.example.bloodbank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class BloodBankController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return "index"; // Points to index.html
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register"; // Points to register.html
    }

    @PostMapping("/register")
    public String registerUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register"; // Return to registration page if errors
        }
        userService.registerUser(user);
        model.addAttribute("successMessage", "User registered successfully!");
        return "index"; // Redirect to index after registration
    }
}
