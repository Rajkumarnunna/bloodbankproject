package com.example.bloodbank.service;

import com.example.bloodbank.dto.FeedbackDTO;
import com.example.bloodbank.entity.Feedback;
import com.example.bloodbank.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    // Method to submit feedback
    public void submitFeedback(FeedbackDTO feedbackDTO) {
        Feedback feedback = new Feedback();
        feedback.setName(feedbackDTO.getName());
        feedback.setEmail(feedbackDTO.getEmail());
        feedback.setMessage(feedbackDTO.getMessage());
        feedbackRepository.save(feedback);
    }

    // Method to get all feedback
    public List<FeedbackDTO> getAllFeedback() {
        return feedbackRepository.findAll().stream()
                .map(feedback -> new FeedbackDTO(feedback.getName(), feedback.getEmail(), feedback.getMessage()))
                .collect(Collectors.toList());
    }
}
