package com.spring.lms.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Course implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int courseId;
	
	@Column(nullable = false)
	private String courseName;
	
	@Column(nullable = false)
	private String courseDescripition;
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_fk" , referencedColumnName = "courseId")
	private List<Chapters> chapters;
	
	

	public List<Chapters> getChapters() {
		return chapters;
	}

	public void setChapters(List<Chapters> chapters) {
		this.chapters = chapters;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDescripition() {
		return courseDescripition;
	}

	public void setCourseDescripition(String courseDescripition) {
		this.courseDescripition = courseDescripition;
	}



	
	

}
