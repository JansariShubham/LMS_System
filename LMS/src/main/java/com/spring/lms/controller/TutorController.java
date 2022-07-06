package com.spring.lms.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private Logger logger = LoggerFactory.getLogger(TutorController.class);

	/*@PostMapping("/tutor/{profileImage}")
	public User addTutor(@RequestBody User user,@PathVariable ("profileImage") MultipartFile file ) throws IOException {
		System.out.println("in add tutor");
		User userobj=userService.saveTutor(user);
		userService.saveTutorProfileImage(userobj.getUser_id(), file);
		return userobj;
	}*/

	@PostMapping("/tutor")
	public User addTutor(@RequestParam("instructorData") User instructorData,
						 @RequestParam("profileImage") MultipartFile profileImage
						 ){
		logger.info("----> INSIDE ADD TUTOR METHOD");
		logger.info("----> INSTRUCTOR DATA FROM CLIENT SIDE : {}", instructorData);
		logger.info("----> IMAGE DATA FROM CLIENT SIDE");

		try{
			User userObj = userService.saveTutor(instructorData);
			logger.info("----> USER OBJECT SAVED: {}", userObj);
			if(profileImage != null){
				logger.info("---> SAVING PROFILE IMAGE...");
				int tutorId = userObj.getUser_id();
				boolean resultOfImageSave = userService.saveTutorProfileImage(tutorId, profileImage);
				logger.info("---> PROFILE IMAGE SAVE STATUS: {}", resultOfImageSave);
				return resultOfImageSave ? userObj : null;
			}
			return userObj;
		}catch(Exception e){
			logger.info("----> ERROR DURING SAVING INSTRUCTOR DATA: {}", e.getMessage());
		}
		return null;
	}

	@GetMapping("/tutor")
	public List<User> getTutors() {
		return userService.getTutors();
	}

	@GetMapping("/tutor/{user_id}")
	public User getTutorById(@PathVariable int user_id) {
		return userService.getTutorById(user_id);
	}

	@PutMapping("/tutor")
	public User updateTutor(@RequestBody User user)

	{
		return userService.updateTutor(user);

	}

	@DeleteMapping("/tutor/{user_id}")
	public User deleteTutor(@PathVariable int user_id) {
		return userService.deleteTutor(user_id);
	}

//	@PostMapping("/tutor/save-tutor/{id}")
//	public boolean uploadTutorImage(@PathVariable("id") int id,
//			@RequestParam("profileImage") MultipartFile profileImage) throws IOException {
//		System.out.println("\nUpload tutor profile image called....\n");
//		return userService.saveTutorProfileImage(id, profileImage);
//	}

}
