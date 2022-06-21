package com.spring.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.lms.model.ContactUsDetails;
import com.spring.lms.repository.ContactUsDetailsRepo;

@Service
public class ContactUsDetailsService {
	
	@Autowired
	private ContactUsDetailsRepo contactDetailsRepo;

	public ContactUsDetails add(ContactUsDetails contactUs) {
		// TODO Auto-generated method stub
		return contactDetailsRepo.save(contactUs);
	}

}
