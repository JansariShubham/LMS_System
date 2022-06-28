package com.spring.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.lms.model.Course;
import com.spring.lms.model.Tutor;
import com.spring.lms.model.User;
import com.spring.lms.service.TutorService;
import com.spring.lms.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TutorController {
	
	@Autowired
	private TutorService tutorService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/tutor")
	public User addTutor(@RequestBody User user)
	{
		System.out.println("in add tutor");
		return userService.saveTutor(user);
		 
	}
	
	@GetMapping("/tutor")
	public List<User> getTutors()
	{
		return userService.getTutors();
	}
	
	@GetMapping("/tutor/{user_id}")
	public User getTutorById(@PathVariable int user_id)
	{
		return userService.getTutorById(user_id);
	}
	
	@PutMapping("/tutor")
	public User updateTutor(@RequestBody User user)
	
	{
		return userService.updateTutor(user);
		
	}
	
	@DeleteMapping("/tutor/{user_id}")
	public User deleteTutor(@PathVariable int user_id)
	{
		return userService.deleteTutor(user_id);
	}

}

