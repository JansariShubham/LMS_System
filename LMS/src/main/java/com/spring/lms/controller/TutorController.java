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
import com.spring.lms.service.TutorService;

@RestController
@CrossOrigin
public class TutorController {
	
	@Autowired
	private TutorService tutorService;
	
	@PostMapping("/tutor")
	public Tutor addTutor(@RequestBody Tutor tutor)
	{
		return tutorService.saveTutor(tutor);
	}
	
	@GetMapping("/tutor")
	public List<Tutor> getTutors()
	{
		return tutorService.getTutors();
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

