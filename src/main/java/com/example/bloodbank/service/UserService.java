package com.example.bloodbank.service;

import com.example.bloodbank.entities.User;
import com.example.bloodbank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User user) {
        // For now, we're not encoding the password as we're using NoOpPasswordEncoder
        // In a real application, you should use a secure password encoder
        // user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

	public PasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}

	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	public boolean authenticateUser1(String email, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean authenticateUser(String email, String password) {
		// TODO Auto-generated method stub
		return false;
	}
}