package com.spring.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.lms.model.Tutor;

@Repository
public interface TutorRepo extends JpaRepository<Tutor, Integer> {

}
