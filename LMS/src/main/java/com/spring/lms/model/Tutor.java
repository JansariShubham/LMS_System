package com.spring.lms.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Tutor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tutor_id;
	
	@OneToOne(cascade = CascadeType.ALL , orphanRemoval = true)
	@JoinColumn(name = "user_fk")
	private User user;
	
	@OneToMany(cascade = CascadeType.PERSIST,mappedBy = "tutor")
	private List<Course> course;
	
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
}
