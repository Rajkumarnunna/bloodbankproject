package com.example.bloodbank.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @GetMapping
    public String showRegistrationForm() {
        return "registration"; // Name of the HTML file (registration.html) in resources/templates or resources/static
    }
}
