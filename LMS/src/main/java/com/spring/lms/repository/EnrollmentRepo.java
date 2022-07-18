package com.spring.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.lms.model.Enrollment;

@Repository
public interface EnrollmentRepo extends JpaRepository<Enrollment, Integer> {

	Enrollment findByorderId(String orderId);

}
