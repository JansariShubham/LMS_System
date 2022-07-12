package com.spring.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.lms.model.Tutor;

import java.util.List;

@Repository
public interface TutorRepo extends JpaRepository<Tutor, Integer> {

	@Query(value = "SELECT tutor_id FROM tutor WHERE user_fk = :userId", nativeQuery = true)
	int findTutorByUserId(int userId);
}
