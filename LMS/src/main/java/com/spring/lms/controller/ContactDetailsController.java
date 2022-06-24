package com.spring.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.lms.model.ContactDetails;
import com.spring.lms.service.ContactUsService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ContactDetailsController {
	
	@Autowired
	private ContactUsService contactUsService;
	
//	@PostMapping("/saveDetails")
//	public ContactUs saveData( @RequestBody ContactUs contactus)
//	{
//		return contactUsService.addData(contactus);
//	}

	@PutMapping("/saveDetails")
	public ContactDetails updateData(@RequestBody ContactDetails contactus)
	{
		return contactUsService.updateData(contactus);
	}
	
	@GetMapping("/saveDetails")
	public List<ContactDetails> getData()
	{
		return contactUsService.getData();
	}
}
