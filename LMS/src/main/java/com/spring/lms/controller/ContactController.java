package com.spring.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.lms.model.ContactDetails;
import com.spring.lms.model.Contact;
import com.spring.lms.service.ContactUsDetailsService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ContactController {
	
	@Autowired
	private ContactUsDetailsService conatctUsDeatilsService;
	
	@PostMapping("/contact")
	public Contact save( @RequestBody Contact contactUs)
	{
		return conatctUsDeatilsService.add(contactUs);
	}
	
	@GetMapping("/contact")
	public List<Contact> getDetails()
	{
		return conatctUsDeatilsService.getDetails();
	}

}
