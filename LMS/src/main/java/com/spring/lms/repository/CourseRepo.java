package com.spring.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.lms.model.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, Integer>{

	Course findBycourseName(String courseName);
//
//	@Query("SELECT c.courseId, c.courseName, c.courseDuration, c.courseRating, c.courseStatus, c.coursePrice, c.courseImage, u.firstName, u.profileImage  FROM Course c INNER JOIN Tutor t ON (c.tutor_fk = t.tutor_id) INNER JOIN User u ON (t.user_fk = u.user_id) ")
////	@Query("SELECT c.course_id, c.course_name, c.course_duration, c.course_rating, c.course_status, c.course_price, c.course_image, u.first_name, u.profile_image  FROM Course as c INNER JOIN Tutor as t ON (c.tutor_fk = t.tutor_id) INNER JOIN User as u ON (t.user_fk = u.user_id)")
//	String[] getCourses();

}
