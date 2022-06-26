package com.spring.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.lms.service.EmailService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmailController {
	
	@Autowired
	EmailService emailService;
	
	@GetMapping("/email")
	public SimpleMailMessage getEmail()
	{
		return emailService.sendEmail();
	}

}
