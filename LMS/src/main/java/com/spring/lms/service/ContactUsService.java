package com.spring.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.lms.model.ContactDetails;
import com.spring.lms.repository.ContactUsRepo;

@Service
public class ContactUsService {
	
	@Autowired
	private ContactUsRepo contactUsRepo;

	public ContactDetails addData(ContactDetails contactus) {
		// TODO Auto-generated method stub
		return contactUsRepo.save(contactus);
	}

	public ContactDetails updateData(ContactDetails contactus) {
		// TODO Auto-generated method stub
		
		ContactDetails exisitingData=contactUsRepo.findById(contactus.getcId()).orElse(null);
		exisitingData.setEmailId(contactus.getEmailId());
		exisitingData.setPhoneNumber(contactus.getPhoneNumber());
		exisitingData.setAddress(contactus.getAddress());
		
		return contactUsRepo.save(exisitingData) ;
	}

	public List<ContactDetails> getData() {
		// TODO Auto-generated method stub
		return contactUsRepo.findAll();
	}

}
