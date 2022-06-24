package com.spring.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.lms.model.ContactDetails;

@Repository
public interface ContactUsRepo extends JpaRepository<ContactDetails,Integer> {

}
