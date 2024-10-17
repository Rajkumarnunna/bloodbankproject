package com.example.bloodbank;

import com.example.bloodbank.dto.DonationRequestDTO;
import com.example.bloodbank.entity.BloodDonation;
import com.example.bloodbank.repository.DonationRequestRepository;
import com.example.bloodbank.service.DonationService;
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
    private DonationService donationService;

    @Mock
    private DonationRequestRepository donationRequestRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testDonateBlood() {
        // Create a DonationRequestDTO for the test
        DonationRequestDTO donationRequestDTO = new DonationRequestDTO();
        donationRequestDTO.setPatientName("John Doe");
        donationRequestDTO.setBloodGroup("A+");
        donationRequestDTO.setCity("New York");

        // Mock the repository save method
        BloodDonation bloodDonation = new BloodDonation();
        bloodDonation.setPatientName("John Doe");
        bloodDonation.setBloodGroup("A+");

        when(donationRequestRepository.save(any(BloodDonation.class))).thenReturn(bloodDonation);

        // Call the service with DonationRequestDTO
        BloodDonation result = donationService.donateBlood(donationRequestDTO);
        assertNotNull(result);
        assertEquals("John Doe", result.getPatientName());  // This should now pass
        verify(donationRequestRepository, times(1)).save(any(BloodDonation.class));
    

    }
}
