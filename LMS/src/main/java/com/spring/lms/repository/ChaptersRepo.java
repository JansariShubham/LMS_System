package com.spring.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.lms.model.Chapters;

@Repository
public interface ChaptersRepo extends JpaRepository<Chapters, Integer> {


	Chapters findBychapterName(String chapterName);

}
