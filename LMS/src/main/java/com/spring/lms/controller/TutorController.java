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
	public List<User> getTutors(User user)
	{
		return userService.getTutors(user);
	}
	
	@GetMapping("/tutor/{tutor_id}")
	public Tutor getTutorById(@PathVariable int tutor_id)
	{
		return tutorService.getTutorById(tutor_id);
	}
	
	@PutMapping("/tutor")
	public Tutor updateTutor(@RequestBody Tutor tutor)
	{
		return tutorService.updateTutor(tutor);
		
	}
	
	@DeleteMapping("/tutor/{tutor_id}")
	public String deleteTutor(@PathVariable int tutor_id)
	{
		return tutorService.deleteTutor(tutor_id);
	}

}

