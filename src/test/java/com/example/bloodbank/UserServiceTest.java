package com.example.bloodbank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.bloodbank.entity.User;
import com.example.bloodbank.repository.UserRepository;
import com.example.bloodbank.service.UserService;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void testRegisterUser() {
        // Given
        User user = new User();
        user.setUsername("testuser");
        user.setPassword("password");  // Plain password for input

        // When
        userService.registerUser(user);  // The password will be hashed in the service

        // Then
        // Ensure that the password is now hashed
        assertNotEquals("password", user.getPassword());  // Check it's no longer plain
        assertTrue(passwordEncoder.matches("password", user.getPassword())); // Check that the hashed password matches
    }
}
