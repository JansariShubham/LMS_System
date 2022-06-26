package com.spring.lms.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int user_id;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Column(unique = true, nullable = false)
	private String emailId;

	@Column(nullable = false)
	private char[] password;

	@Column(nullable = false)
	private String role;

	@Column(nullable = true)
	private String phoneNum;

	@Transient
	private boolean emailError;

	@Transient
	private boolean passwordError;
	
	@OneToOne(cascade = CascadeType.ALL , mappedBy = "user")
	private Tutor tutor;

	public boolean isEmailError() {
		return emailError;
	}

	public void setEmailError(boolean emailError) {
		this.emailError = emailError;
	}

	public boolean isPasswordError() {
		return passwordError;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

	public void setPasswordError(boolean passwordError) {
		this.passwordError = passwordError;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}
	
	

}
