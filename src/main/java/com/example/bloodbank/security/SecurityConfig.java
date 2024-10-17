package com.example.bloodbank.security;

import com.example.bloodbank.service.CustomUserDetailsService;
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

    private final CustomUserDetailsService userDetailsService;

    public SecurityConfig(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())  // Disable CSRF protection (make sure to enable this in production)
            .authorizeHttpRequests(auth -> 
                auth
                    .requestMatchers("/login", "/register", "/home", "/donate", "/request-blood").permitAll()  // Publicly accessible pages
                    .requestMatchers("/admin/**").hasRole("ADMIN")  // Admin pages require ADMIN role
                    .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")  // User pages require USER or ADMIN roles
                    .anyRequest().authenticated()  // All other pages require authentication
            )
            .formLogin(form -> 
                form.loginPage("/login")  // Custom login page
                    .defaultSuccessUrl("/home", true)  // Redirect to home page after successful login
                    .permitAll()
            )
            .logout(logout -> 
                logout.logoutUrl("/logout")  // Custom logout URL
                    .logoutSuccessUrl("/login?logout")  // Redirect to login page after logout
                    .permitAll()
            );

        return http.build();  // Return the built HttpSecurity object
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Password encoder to hash passwords
    }
}
