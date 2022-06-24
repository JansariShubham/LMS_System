package com.spring.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.lms.model.Contact;
import com.spring.lms.repository.ContactUsDetailsRepo;

@Service
public class ContactUsDetailsService {
	
	@Autowired
	private ContactUsDetailsRepo contactDetailsRepo;

	public Contact add(Contact contactUs) {
		// TODO Auto-generated method stub
		return contactDetailsRepo.save(contactUs);
	}

	public List<Contact> getDetails() {
		// TODO Auto-generated method stub
		return contactDetailsRepo.findAll();
	}

}
