package com.spring.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spring.lms.dto.CoursesDTO;
import com.spring.lms.model.Course;
import com.spring.lms.model.Tutor;
import com.spring.lms.repository.CourseRepo;
import com.spring.lms.repository.TutorRepo;

@Service
public class CourseService {

	@Autowired
	private CourseRepo courseRepo;

	@Autowired
	private TutorRepo tutorRepo;

	public Course saveCourse(Course course) {
		// Tutor t = course.getTutor();
		// course.setTutor(t);
		Tutor tutorId = tutorRepo.findById(course.getTutorId()).orElse(null);
		course.setTutor(tutorId);
		return courseRepo.save(course);
	}

	public List<CoursesDTO> getCourses() {
		// TODO Auto-generated method stub
		return courseRepo.getCourses();
	}

	public CoursesDTO getCourse(int courseId) {
		// TODO Auto-generated method stub
		return courseRepo.getCourse(courseId);
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

	public boolean savecourseImage(int id, MultipartFile courseImage) {
		// TODO Auto-generated method stub

		Optional<Course> courseobj = courseRepo.findById(id);
		if (courseobj.isPresent()) {
			Course obj = courseobj.get();
			try {
				obj.setCourseImage(courseImage.getBytes());
				courseRepo.save(obj);
				return true;
			} catch (Exception e) {
				System.out.println("\nError during file upload... " + e.getMessage());
				e.printStackTrace();
				return false;
			}
		} else
			return false;
	}

	public Optional<Course> getCourseDetailsById(int courseId) {
		return courseRepo.findById(courseId);
	}
}
