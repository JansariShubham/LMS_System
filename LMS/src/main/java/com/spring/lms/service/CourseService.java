package com.spring.lms.service;

import com.spring.lms.dto.CoursesDTO;
import com.spring.lms.model.Course;
import com.spring.lms.model.Tutor;
import com.spring.lms.repository.CourseRepo;
import com.spring.lms.repository.TutorRepo;
import com.spring.lms.utility.NewsLetterUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseService {

	@Autowired
	private ChapterService chapterService;
	
	@Autowired
	private CourseRepo courseRepo;
	
	@Autowired
	private UserReviewsService userReviewsService;

	@Autowired
	private TutorRepo tutorRepo;

	@Autowired
	private NewsLetterUtility newsLetterUtility;

	@Value("${app.host.port}")
	private String hostAddress;

	public Course saveCourse(Course course) {
		// Tutor t = course.getTutor();
		// course.setTutor(t);
		int userId = course.getUserId();
		int tutorId = tutorRepo.findTutorByUserId(userId);
		Tutor tutor = tutorRepo.findById(tutorId).orElse(null);
		course.setTutor(tutor);
		System.out.println("save course!");

		sendNewsLetterUpdate(course.getCourseId(), course.getTutor(), course.getCourseName(), course.getCoursePrice());

		return courseRepo.save(course);
	}

	private void sendNewsLetterUpdate(int courseId, Tutor tutor, String courseName, int coursePrice) {

		String emailSubject = tutor.getUser().getFirstName() + " Added " + courseName  + " !!";

		String link = this.hostAddress + "homepage/courses/" + courseId;
		String emailBody
				= 	"<div style = 'background-color:gray'>" +
					"<h2 style = 'border:2px solid black; font-size: 2rem; padding: 0.5rem; font-weight:bold'>" +
					courseName.toUpperCase() + " BY " + tutor.getUser().getFirstName().toUpperCase() +
					"</h2>" +
						"<div style = 'font-size: 1rem;'>" +
							"<p>Checkout this course </p>" +
							"<a href ="+ link + ">" + courseName + "</a>" +
							"<br><br>" +
							"<span style = 'font-weight:bold;'>Course Will Start Soon. Click Above Link For More Details.</span>" +
							"<span style = 'font-weight:bold;'>Course Price:" + coursePrice + " Rs.</span>" +
							"<p style='font-style:italic; font-weight:bold'>Happy Learning, <br> CourseLog.</p>" +
						"</div>" +
					"</div>";
		newsLetterUtility.sendNewsLetterUpdateEmail(emailSubject, emailBody);
	}

	public List<CoursesDTO> getCourses() {
		// TODO Auto-generated method stub
		List<CoursesDTO> list = courseRepo.getCourses();
		list.stream().map(l -> {
			l.setChapters(chapterService.getChaptersList(l.getCourseId()));
			l.setCourseReviews(userReviewsService.loadAllUserReviewForCourse(l.getCourseId()));
			return l;
		}).collect(Collectors.toList());
		return list;
	}

	public CoursesDTO getCourse(int courseId) {
		// TODO Auto-generated method stub
		CoursesDTO course = courseRepo.getCourse(courseId);
		course.setChapters(chapterService.getChaptersList(course.getCourseId()));
		course.setCourseReviews(userReviewsService.loadAllUserReviewForCourse(course.getCourseId()));
		return course;
	}

//	public Course getCourseByName(String courseName) {
//		// TODO Auto-generated method stub
//		return courseRepo.findBycourseName(courseName);
//	}

	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
		
		int userId = course.getUserId();
		int tutorId = tutorRepo.findTutorByUserId(userId);
		Tutor tutor = tutorRepo.findById(tutorId).orElse(null);
		Course existingCourse = courseRepo.findById(course.getCourseId()).orElse(null);
		existingCourse.setCourseName(course.getCourseName());
		existingCourse.setCourseDescription(course.getCourseDescription());
		existingCourse.setCoursePrice(course.getCoursePrice());
		existingCourse.setCourseDuration(course.getCourseDuration());
		existingCourse.setCourseDate(course.getCourseDate());
		existingCourse.setTutor(tutor);
		return courseRepo.save(existingCourse);
	}

	public String deleteCourse(int courseId) {
		// TODO Auto-generated method stub
		courseRepo.deleteById(courseId);
		return null;
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


    public void updateCourseRating(int courseRating, int courseId) {

		courseRepo.updateCourseRatingById(courseRating, courseId);
	}
}
