package com.spring.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.spring.lms.model.User;

@Repository
public interface RegistartionRepo extends JpaRepository<User,Integer>{

	User findByEmailId(String emailId);

	List<User> findByrole(String role);
	
	

}
