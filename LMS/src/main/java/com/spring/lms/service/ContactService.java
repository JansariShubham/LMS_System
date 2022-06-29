package com.spring.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.lms.model.Contact;
import com.spring.lms.model.User;
import com.spring.lms.repository.ContactRepo;

@Service
public class ContactService {
	
	@Autowired
	private ContactRepo contactRepo;

	public Contact add(Contact contactUs) {
		// TODO Auto-generated method stub
		return contactRepo.save(contactUs);
	}

	public List<Contact> getDetails() {
		// TODO Auto-generated method stub
		return contactRepo.findAll();
	}

	public Contact getcontactById(int cId) {
		// TODO Auto-generated method stub
		return contactRepo.findById(cId).orElse(null);
	}

}
