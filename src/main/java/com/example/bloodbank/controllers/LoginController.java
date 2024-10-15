package com.example.bloodbank.controllers;

import com.example.bloodbank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    // Show login page
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    // Handle login form submission
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        if (userService.authenticateUser(email, password)) {
            // Redirect to dashboard if login is successful
            return "redirect:/dashboard";
        } else {
            // If login fails, display an error message
            model.addAttribute("error", "Invalid email or password");
            return "login";
        }
    }
}
