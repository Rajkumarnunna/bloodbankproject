package com.example.bloodbank.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String bloodGroup;
    private String city;
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public List<BloodRequest> getBloodRequests() {
		return bloodRequests;
	}

	public void setBloodRequests(List<BloodRequest> bloodRequests) {
		this.bloodRequests = bloodRequests;
	}

	public List<BloodDonation> getBloodDonations() {
		return bloodDonations;
	}

	public void setBloodDonations(List<BloodDonation> bloodDonations) {
		this.bloodDonations = bloodDonations;
	}

	@Enumerated(EnumType.STRING)
    private UserType userType;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<BloodRequest> bloodRequests;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<BloodDonation> bloodDonations;

	public Object getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setPassword(String encode) {
		// TODO Auto-generated method stub
		
	}
}

enum UserType {
    DONOR, REQUESTOR, ADMIN
}