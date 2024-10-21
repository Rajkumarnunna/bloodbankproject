package com.example.bloodbank;

import com.example.bloodbank.dto.DonationRequestDTO;
import com.example.bloodbank.entity.BloodDonation;
import com.example.bloodbank.repository.DonationRequestRepository;
import com.example.bloodbank.service.DonationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class DonationServiceTest {

    @InjectMocks
    private DonationServiceImpl donationService; // Inject the service implementation

    @Mock
    private DonationRequestRepository donationRequestRepository; // Mock the repository

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks before each test
    }

    @Test
    void testDonateBlood() {
        // Arrange: Create a DonationRequestDTO for the test
        DonationRequestDTO donationRequestDTO = new DonationRequestDTO();
        donationRequestDTO.setDonorName("John Doe"); // Set donor name
        donationRequestDTO.setBloodGroup("A+"); // Set blood group
        donationRequestDTO.setAmount(500.0); // Set donation amount

        // Create a BloodDonation entity that the repository will return
        BloodDonation mockBloodDonation = new BloodDonation();
        mockBloodDonation.setDonorName("John Doe");
        mockBloodDonation.setBloodGroup("A+");
        mockBloodDonation.setAmount(500.0);

        // Act: Mock the repository save method to return the mockBloodDonation entity
        when(donationRequestRepository.save(any(BloodDonation.class))).thenReturn(mockBloodDonation);

        // Call the donateBlood method of the service with the DTO
        BloodDonation result = donationService.donateBlood(donationRequestDTO);

        // Assert: Validate that the returned BloodDonation matches the expected values
        assertNotNull(result, "The returned blood donation should not be null");
        assertEquals("John Doe", result.getDonorName(), "The donor name should match the expected value");
        assertEquals("A+", result.getBloodGroup(), "The blood group should match the expected value");
        assertEquals(500.0, result.getAmount(), "The donation amount should match the expected value");

        // Verify that the repository's save method was called exactly once
        verify(donationRequestRepository, times(1)).save(any(BloodDonation.class));
    }
}
