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
            .authorizeHttpRequests(authorizeRequests -> 
                authorizeRequests
                    .requestMatchers("/api/users/register").permitAll() // Allow user registration
                    .requestMatchers("/api/login").permitAll() // Allow login access
                    .anyRequest().authenticated() // All other requests require authentication
            )
            .formLogin().loginPage("/login").permitAll() // Specify login page if using form-based auth
            .and()
            .logout().permitAll() // Allow logout access
            .and()
            .csrf().disable(); // Disable CSRF protection for simplicity in API (consider enabling in production)

        return http.build();
    }
}
