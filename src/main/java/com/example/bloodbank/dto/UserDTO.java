package com.example.bloodbank.dto;

import com.example.bloodbank.entity.User;

public class UserDTO {

    private String firstName;
    private String lastName;
    private String bloodGroup;
    private String city;
    private String role;  // Add role field here

    public UserDTO() {
		// TODO Auto-generated constructor stub
	}

	// Getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRole() {   // Add getter for role
        return role;
    }

    public void setRole(String role) {   // Add setter for role
        this.role = role;
    }

	public void setUsername(String username) {
		// TODO Auto-generated method stub
		
	}
}
