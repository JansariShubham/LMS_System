package com.spring.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.lms.model.ContactUs;

@Repository
public interface ContactUsRepo extends JpaRepository<ContactUs,Integer> {

}
