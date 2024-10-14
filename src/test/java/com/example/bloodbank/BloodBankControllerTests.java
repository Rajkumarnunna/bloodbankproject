package com.example.bloodbank;

import com.example.bloodbank.controllers.BloodBankController;
import com.example.bloodbank.service.BloodService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class BloodBankControllerTests {

    @InjectMocks
    private BloodBankController bloodBankController;

    @Mock
    private BloodService bloodService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCheckBloodAvailability() {
        // Given
        String bloodType = "A+";
        when(bloodService.checkBloodAvailability(bloodType)).thenReturn(true);

        // When
        boolean isAvailable = bloodBankController.checkBloodAvailability(bloodType);

        // Then
        assertEquals(true, isAvailable);
    }

    @Test
    void testRegisterUser() {
        // Given
        String name = "John Doe";
        String email = "johndoe@example.com";
        String phone = "1234567890";
        String bloodType = "A+";

        // This test checks if the method can be called without exceptions
        bloodBankController.registerUser(name, email, phone, bloodType);

        // Add assertions if needed to check side effects, like if the user was saved
        // For example, you can check if the bloodService method was called (if applicable)
    }
}
