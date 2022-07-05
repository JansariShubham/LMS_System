package com.spring.lms.model;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
@Entity
public class Enrollment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int enrollmentId;

	public int getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(int enrollmentId) {
		this.enrollmentId = enrollmentId;
	}
	
	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "user_fk")
//	private List<User> user;
//
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "course_fk")
//	private List<Course> course;
//
//	public List<User> getUser() {
//		return user;
//	}
//
//	public void setUser(List<User> user) {
//		this.user = user;
//	}
//
//	public List<Course> getCourse() {
//		return course;
//	}
//
//	public void setCourse(List<Course> course) {
//		this.course = course;
//	}

}
