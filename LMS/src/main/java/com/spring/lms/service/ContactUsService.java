package com.spring.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.lms.model.ContactUs;
import com.spring.lms.repository.ContactUsRepo;

@Service
public class ContactUsService {
	
	@Autowired
	private ContactUsRepo contactUsRepo;

	public ContactUs addData(ContactUs contactus) {
		// TODO Auto-generated method stub
		return contactUsRepo.save(contactus);
	}

	public ContactUs updateData(ContactUs contactus) {
		// TODO Auto-generated method stub
		
		ContactUs exisitingData=contactUsRepo.findById(contactus.getcId()).orElse(null);
		exisitingData.setEmailId(contactus.getEmailId());
		exisitingData.setPhoneNumber(contactus.getPhoneNumber());
		exisitingData.setAddress(contactus.getAddress());
		
		return contactUsRepo.save(exisitingData) ;
	}

}
