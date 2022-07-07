package com.spring.lms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.lms.model.Chapters;

@Repository
public interface ChaptersRepo extends JpaRepository<Chapters, Integer> {


	Chapters findBychapterName(String chapterName);
	
	@Query(value = "SELECT c.chapter_id, c.chapter_date, c.chapter_name, c.chapterlink FROM chapters as c WHERE c.course_fk = :courseId", nativeQuery = true )
	List<Chapters> findByCourseId(int courseId);

}
