package com.spring.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.lms.model.ContactUs;
import com.spring.lms.service.ContactUsService;

@RestController
@CrossOrigin
public class ContactUsController {
	
	@Autowired
	private ContactUsService contactUsService;
	
	@PostMapping("/saveDetails")
	public ContactUs saveData( @RequestBody ContactUs contactus)
	{
		return contactUsService.addData(contactus);
	}

	@PutMapping("/saveDetails")
	public ContactUs updateData(@RequestBody ContactUs contactus)
	{
		return contactUsService.updateData(contactus);
	}
}
