package com.example.bloodbank.controllers;

import com.example.bloodbank.entities.User;
import com.example.bloodbank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class LoginController {

    private final UserRepository userRepository;

    @Autowired
    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String email, @RequestParam String password, Model model) {
        Optional<User> user = Optional.ofNullable(userRepository.findByEmail(email));

        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return "redirect:/"; // redirect to home page after successful login
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "login"; // show login page with error message
        }
    }
}
