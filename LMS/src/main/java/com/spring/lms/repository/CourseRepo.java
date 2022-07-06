package com.spring.lms.repository;

import java.util.List;

import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.lms.dto.CoursesDTO;
import com.spring.lms.model.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, Integer>{

	Course findBycourseName(String courseName);
	
	@Query("SELECT new com.spring.lms.dto.CoursesDTO(c.courseId, c.courseName, c.courseDescription, c.coursePrice, c.courseDuration, c.courseDate, c.courseImage, c.courseRating, c.courseStatus, u.firstName, u.lastName, u.profileImage) "
			+ "FROM Course as c "
			+ "INNER JOIN Tutor as t ON (c.tutor = t.tutor_id) "
			+ "INNER JOIN User as u ON (t.user = u.user_id)")
	List<CoursesDTO> getCourses();
	
	@Query("SELECT new com.spring.lms.dto.CoursesDTO(c.courseId, c.courseName, c.courseDescription, c.coursePrice, c.courseDuration, c.courseDate, c.courseImage, c.courseRating, c.courseStatus, u.firstName, u.lastName, u.profileImage) "
			+ " FROM Course as c"
			+ " INNER JOIN Tutor as t ON (c.tutor = t.tutor_id)"
			+ " INNER JOIN User as u ON (t.user = u.user_id)"
			+ " WHERE c.courseId = :courseId")
	CoursesDTO getCourse(int courseId);	
}