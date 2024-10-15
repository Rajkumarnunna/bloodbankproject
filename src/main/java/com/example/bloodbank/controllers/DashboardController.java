package com.example.bloodbank.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard() {
        // Add any dashboard-specific logic here
        return "dashboard";  // Return dashboard view
    }
}
