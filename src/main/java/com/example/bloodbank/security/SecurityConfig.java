package com.example.bloodbank.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Authorization settings
            .authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                    .requestMatchers("/public/**").permitAll() // Allow access to public resources
                    .requestMatchers("/api/users/register", "/api/users/login").permitAll() // Allow access to registration and login
                    .anyRequest().authenticated() // All other requests require authentication
            )
            // Form login settings
            .formLogin(formLogin ->
                formLogin
                    .loginPage("/bloodbank/login") // Custom login page URL
                    .defaultSuccessUrl("/bloodbank/home", true) // Redirect to home page upon successful login
                    .permitAll() // Allow everyone to access the login page
            )
            // Logout settings
            .logout(logout ->
                logout
                    .logoutUrl("/bloodbank/logout") // Custom logout URL
                    .logoutSuccessUrl("/bloodbank/login?logout") // Redirect to login page after logout
                    .permitAll() // Allow everyone to access the logout functionality
            )
            .csrf().disable(); // Disable CSRF protection if you're using stateless REST APIs

        return http.build();
    }

}
