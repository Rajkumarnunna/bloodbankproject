package com.example.bloodbank.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/check-availability")
    public String checkAvailability() {
        return "check_availability";
    }

    @GetMapping("/donate-blood")
    public String donateBlood() {
        return "donate_blood";
    }

    @GetMapping("/request-blood")
    public String requestBlood() {
        return "request_blood";
    }
}