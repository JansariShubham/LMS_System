package com.spring.lms.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
	private ChapterService chapterService;
	
	@Autowired
	private CourseRepo courseRepo;

	@Autowired
	private TutorRepo tutorRepo;

	public Course saveCourse(Course course) {
		// Tutor t = course.getTutor();
		// course.setTutor(t);
		int userId = course.getUserId();
		int tutorId = tutorRepo.findTutorByUserId(userId);
		Tutor tutor = tutorRepo.findById(tutorId).orElse(null);
		course.setTutor(tutor);
		return courseRepo.save(course);
	}

	public List<CoursesDTO> getCourses() {
		// TODO Auto-generated method stub
		List<CoursesDTO> list = courseRepo.getCourses();
		list.stream().map(l -> {
			l.setChapters(chapterService.getChaptersList(l.getCourseId()));
			return l;
		}).collect(Collectors.toList());
		return list;
	}

	public CoursesDTO getCourse(int courseId) {
		// TODO Auto-generated method stub
		CoursesDTO course = courseRepo.getCourse(courseId);
		course.setChapters(chapterService.getChaptersList(course.getCourseId()));
		return course;
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
		Optional<Course> gcCourse = courseRepo.findByCourseId(courseId);
		System.out.println("\n\n GC Course: " + gcCourse);
		return gcCourse;
	}
}
