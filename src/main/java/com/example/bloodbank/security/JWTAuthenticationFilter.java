package com.example.bloodbank.security;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JWTAuthenticationFilter extends OncePerRequestFilter {

    // Constructor
    public JWTAuthenticationFilter() {
        // You can add dependencies to the constructor if needed
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        // Extract the token from the Authorization header
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            String token = header.substring(7); // Remove "Bearer " prefix

            // Validate the token and retrieve the user details (this is simplified)
            if (isValidToken(token)) {
                // Set authentication in the context
                String username = getUsernameFromToken(token); // Extract username from token
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(username, null, null);
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        chain.doFilter(request, response); // Continue the filter chain
    }

    // Dummy method to validate the token (replace with your actual logic)
    private boolean isValidToken(String token) {
        return "valid.jwt.token".equals(token); // Simple check for example
    }

    // Dummy method to extract username from the token (replace with your logic)
    private String getUsernameFromToken(String token) {
        return "expectedUsername"; // Replace with actual extraction logic
    }
}
