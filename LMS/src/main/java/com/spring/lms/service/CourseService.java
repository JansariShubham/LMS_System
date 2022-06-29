package com.spring.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.lms.model.Chapters;
import com.spring.lms.model.Course;
import com.spring.lms.repository.ChaptersRepo;
import com.spring.lms.repository.CourseRepo;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepo courseRepo;
	
	
	public Course saveCourse(Course course) {
		 return courseRepo.save(course);
		
	}

	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return courseRepo.findAll();
	}

	public Course getCourse(int courseId) {
		// TODO Auto-generated method stub
		return courseRepo.findById(courseId).orElse(null);
	}

//	public Course getCourseByName(String courseName) {
//		// TODO Auto-generated method stub
//		return courseRepo.findBycourseName(courseName);
//	}

	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
		Course existingCourse = courseRepo.findById(course.getCourseId()).orElse(null);
		existingCourse.setCourseName(course.getCourseName());
		existingCourse.setCourseDescription(course.getCourseDescription());
		return courseRepo.save(existingCourse);
		
	}

	public String deleteCourse(int courseId) {
		// TODO Auto-generated method stub
			courseRepo.deleteById(courseId);
			return "Course Removed!! " + courseId;
	}

}
