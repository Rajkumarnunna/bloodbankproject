package com.example.bloodbank.entity;

import jakarta.persistence.*;

@Entity
public class BloodDonation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patientName;
    private String bloodGroup;
    private String city;  // The city field should be a String

    // Getters and Setters
    public String getCity() {
        return city;
    }

    public void setCity(String city) {  // Ensure this method accepts a String, not a Class
        this.city = city;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getStatus() {
		// TODO Auto-generated method stub
		return null;
	}

    // Other fields, getters, and setters...
}
