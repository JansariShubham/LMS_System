package com.spring.lms.model;

import java.util.List;

import javax.persistence.*;
//import javax.persistence.CascadeType;

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

	@Lob
	@Column(name = "profile_image", length = Integer.MAX_VALUE)
	byte[] profileImage;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
	private Tutor tutor;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Course> course;

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

	public byte[] getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(byte[] profileImage) {
		this.profileImage = profileImage;
	}

	public List<Course> getCourse() {
		return course;
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}

}
