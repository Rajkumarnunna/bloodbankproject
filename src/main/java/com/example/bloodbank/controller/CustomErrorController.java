package com.example.bloodbank.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {

    // Endpoint to handle errors
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        // Retrieve the error status code from the request
        Integer statusCode = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        
        // If a status code is present, add it to the model
        if (statusCode != null) {
            model.addAttribute("statusCode", statusCode.toString());
            
            // Retrieve the error message from the request and add it to the model
            String errorMessage = (String) request.getAttribute(RequestDispatcher.ERROR_MESSAGE);
            if (errorMessage != null) {
                model.addAttribute("errorMessage", errorMessage);
            }
        }
        
        // Return the name of the error template
        return "error";  // Ensure you have an error.html template in your templates directory
    }

   
}
