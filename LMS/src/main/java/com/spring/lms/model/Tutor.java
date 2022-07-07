package com.spring.lms.model;

import java.util.List;

import javax.persistence.*;

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
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "tutor")
	private List<Course> course;
//
//	@Lob
//	@Column(name = "tutor_image", length = Integer.MAX_VALUE, nullable = true)
//	private byte[] tutorImage;

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

//	public byte[] getTutorImage() {
//		return tutorImage;
//	}
//
//	public void setTutorImage(byte[] tutorImage) {
//		this.tutorImage = tutorImage;
//	}
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
