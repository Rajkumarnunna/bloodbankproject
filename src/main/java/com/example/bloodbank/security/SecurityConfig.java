package com.example.bloodbank.security;

import com.example.bloodbank.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private final CustomUserDetailsService userDetailsService;

    public SecurityConfig(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> 
                auth
                    .requestMatchers("/register", "/login", "/css/**", "/js/**").permitAll()  // Allow public access to these paths
                    .anyRequest().authenticated()  // Protect all other paths
            )
            .formLogin(form ->
                form.loginPage("/login")  // Specify custom login page
                    .defaultSuccessUrl("/home", true)  // Redirect to /home after successful login
                    .permitAll()
            )
            .logout(logout ->
                logout.logoutUrl("/logout")
                    .logoutSuccessUrl("/login?logout")  // Redirect to login page after logout
                    .permitAll()
            );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

	public CustomUserDetailsService getUserDetailsService() {
		return userDetailsService;
	}
}
