package com.spring.lms.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Tutor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tutor_id;
	
//	@Column(nullable = false)
//	private String firstName;
//	
//	@Column(nullable = false)
//	private String lastName;
//	
//	@Column(unique = true)
//	private String email;
//	
//	@Column(nullable = false)
//	private String phoneNo;
//	
//	@Column(nullable = false)
//	private String password;
//	
	@OneToOne(cascade = CascadeType.ALL , orphanRemoval = true)
	@JoinColumn(name = "user_fk")
	private User user;

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getTutor_id() {
		return tutor_id;
	}
	public void setTutor_id(int tutor_id) {
		this.tutor_id = tutor_id;
	}
//	public String getFirstName() {
//		return firstName;
//	}
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//	public String getLastName() {
//		return lastName;
//	}
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public String getPhoneNo() {
//		return phoneNo;
//	}
//	public void setPhoneNo(String phoneNo) {
//		this.phoneNo = phoneNo;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
	
	
	
}
