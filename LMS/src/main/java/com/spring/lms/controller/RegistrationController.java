package com.spring.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.lms.model.User;
import com.spring.lms.service.UserService;

@RestController
public class RegistrationController {
			
	@Autowired
	UserService userService;
	
	
	@PostMapping("/register")
	public User register(@RequestBody User user)
	{
		
		return userService.signUp(user);
	}
	
	@PostMapping("/login")
	public User login(@RequestBody User user) {
		
		return userService.login(user);
		
	}

}
