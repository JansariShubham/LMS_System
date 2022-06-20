package com.spring.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.lms.dto.CourseDTO;
import com.spring.lms.model.Chapters;
import com.spring.lms.model.Course;
import com.spring.lms.service.CourseService;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@PostMapping("/addCourse")
	public Course saveCourse(@RequestBody Course course)
	{
		 return courseService.saveCourse(course);
		// System.out.println(course.getChapters());
			
	}
	
	
	@GetMapping("/getCourses")
	public List<Course> getCourse()
	{
		return courseService.getCourses();
	}
	
	@GetMapping("/getCourse/{courseId}")
	public Course getCourse(@PathVariable int courseId)
	{
		return courseService.getCourse(courseId);
	}
	
	@GetMapping("/getCourseByName/{courseName}")
	public Course getCourseByName(@PathVariable String courseName)
	{
		return courseService.getCourseByName(courseName);
	}
	
	@PutMapping("/updateCourse")
	public Course updateCourse(@RequestBody Course course)
	{
		return courseService.updateCourse(course);
	}
	
	@DeleteMapping("/deleteCourse/{courseId}")
	public String deleteCourse(@PathVariable int courseId)
	{
			return courseService.deleteCourse(courseId);
	}
		

	
}
