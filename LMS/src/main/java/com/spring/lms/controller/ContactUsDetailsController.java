package com.spring.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.lms.model.ContactUs;
import com.spring.lms.model.ContactUsDetails;
import com.spring.lms.service.ContactUsDetailsService;

@RestController
public class ContactUsDetailsController {
	
	@Autowired
	private ContactUsDetailsService conatctUsDeatilsService;
	
	@PostMapping("/saveContactUs")
	public ContactUsDetails save( @RequestBody ContactUsDetails contactUs)
	{
		return conatctUsDeatilsService.add(contactUs);
	}

}
