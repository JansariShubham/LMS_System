package com.spring.lms.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.spring.lms.model.Course;
import com.spring.lms.model.Tutor;
import com.spring.lms.model.User;
import com.spring.lms.service.TutorService;
import com.spring.lms.service.UserService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

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

	@PostMapping("/tutor/save-tutor/{id}")
	public boolean uploadTutorImage(
									@PathVariable("id") int id,
									@RequestParam("profileImage") MultipartFile profileImage
								 ) throws IOException {
		System.out.println("\nUpload tutor profile image called....\n");
		return userService.saveTutorProfileImage(id, profileImage);
	}

}

