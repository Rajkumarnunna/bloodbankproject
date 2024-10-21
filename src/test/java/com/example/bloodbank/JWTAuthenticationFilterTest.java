package com.example.bloodbank;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.example.bloodbank.security.JWTAuthenticationFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.lang.reflect.Method;

class JWTAuthenticationFilterTest {

    private JWTAuthenticationFilter jwtAuthenticationFilter;

    @BeforeEach
    void setUp() {
        jwtAuthenticationFilter = new JWTAuthenticationFilter();
    }

    private void invokeDoFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws Exception {
        Method method = JWTAuthenticationFilter.class.getDeclaredMethod("doFilterInternal", HttpServletRequest.class, HttpServletResponse.class, FilterChain.class);
        method.setAccessible(true); // Allow access to protected method
        method.invoke(jwtAuthenticationFilter, request, response, chain);
    }

    @Test
    void testDoFilterInternal_ValidToken_SetsAuthentication() throws Exception {
        // Arrange
        String token = "valid.jwt.token"; // Replace with a valid token for your test
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        FilterChain chain = mock(FilterChain.class); // Mocking FilterChain
        when(request.getHeader("Authorization")).thenReturn("Bearer " + token);

        // Act
        invokeDoFilterInternal(request, response, chain);

        // Assert
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        assertNotNull(authentication, "Authentication should be set.");
        assertTrue(authentication instanceof UsernamePasswordAuthenticationToken, "Authentication should be of type UsernamePasswordAuthenticationToken.");
        assertEquals("expectedUsername", authentication.getName(), "The username should match the expected value."); // Replace with expected username
    }

    @Test
    void testDoFilterInternal_InvalidToken_SetsAuthenticationToNull() throws Exception {
        // Arrange
        String token = "invalid.jwt.token"; // Replace with an invalid token for your test
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        FilterChain chain = mock(FilterChain.class); // Mocking FilterChain
        when(request.getHeader("Authorization")).thenReturn("Bearer " + token);

        // Act
        invokeDoFilterInternal(request, response, chain);

        // Assert
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        assertNull(authentication, "Authentication should be null for an invalid token.");
    }
}
