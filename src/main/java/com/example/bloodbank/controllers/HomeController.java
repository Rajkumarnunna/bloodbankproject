package com.example.bloodbank.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Hello from Blood Bank Management System";
    }

    @GetMapping("/test")
    public String test() {
        return "Test endpoint is working";
    }
}