package com.spring.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.lms.model.ContactUsDetails;

@Repository
public interface ContactUsDetailsRepo extends JpaRepository<ContactUsDetails, Integer> {

}
