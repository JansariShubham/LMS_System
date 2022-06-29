package com.spring.lms.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import com.spring.lms.utility.EmailUtility;
//import com.sun.org.apache.xpath.internal.operations.String;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spring.lms.model.Tutor;
import com.spring.lms.model.User;
import com.spring.lms.repository.RegistartionRepo;
import com.spring.lms.repository.TutorRepo;

@Service
public class UserService {

	@Autowired
	private RegistartionRepo repo;

	@Autowired
	private TutorRepo tutorRepo;

	@Autowired
	private EmailUtility emailUtility;

	public User signUp(User user) {

		if (repo.findByEmailId(user.getEmailId()) != null) {
			System.out.println("User is all ready exist!!");
			return null;
		}

		return repo.save(user);
	}

	public User login(User user) {

		User tempUser = repo.findByEmailId(user.getEmailId());
		if (tempUser != null) {
			if (!Arrays.equals(tempUser.getPassword(), user.getPassword())) {
				System.out.println("---> Invalid password...");
				tempUser.setPasswordError(true);
			}
		} else {
			tempUser = new User();
			System.out.println("---> User doesn't exist...");
			tempUser.setEmailError(true);
			;
		}
		return tempUser;
	}

	public User updateUserData(User user) {
		// TODO Auto-generated method stub

		User existingUser = repo.findById(user.getUser_id()).orElse(null);

		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmailId(user.getEmailId());
		existingUser.setPassword(user.getPassword());
		existingUser.setRole(user.getRole());
		existingUser.setPhoneNum(user.getPhoneNum());

		return repo.save(existingUser);
	}

	public User deleteUserData(int user_id) {
		// TODO Auto-generated method stub
		repo.deleteById(user_id);
		return null;

	}

	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public User getUserDataById(int user_id) {
		// TODO Auto-generated method stub
		return repo.findById(user_id).orElse(null);
	}

	@Transactional
	public User saveTutor(User user) {
		// TODO Auto-generated method stub

		Tutor tutor = new Tutor();
		// Tutor tutor;
		User existingUser = repo.findByEmailId(user.getEmailId());

		if (existingUser != null) {
			System.out.println("hii");
			
		
			existingUser.setFirstName(user.getFirstName());
			existingUser.setLastName(user.getLastName());
			existingUser.setPassword(user.getPassword());
			existingUser.setPhoneNum(user.getPhoneNum());
			//existingUser.setImage(file.getBytes());\
			System.out.println(existingUser.getRole());
			if(existingUser.getRole().equals("student"))
			{
				System.out.println("hello");
				
				existingUser.setRole("tutor"); 
				tutor.setUser(existingUser);
				
				tutorRepo.save(tutor);
				
			}
			
			
			tutor.setUser(existingUser);
			return repo.save(existingUser);
		} else {
			System.out.println("hello ,,,");
			//user.setImage(file.getBytes());
			tutor.setUser(user);
			tutorRepo.save(tutor);
			
			// return signUp(user);

		}
		return null;

	}

	public List<User> getTutors() {
		// TODO Auto-generated method stub
		return repo.findByrole("tutor");
	}

	public User updateTutor(User user) {
		// TODO Auto-generated method stub
		User existingUser = repo.findById(user.getUser_id()).orElse(null);
		existingUser.setEmailId(user.getEmailId());
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setPassword(user.getPassword());
		existingUser.setPhoneNum(user.getPhoneNum());
		return repo.save(existingUser);
	}

	public User deleteTutor(int user_id) {
		// TODO Auto-generated method stub
		repo.deleteById(user_id);
		return null;
	}

	public User getTutorById(int user_id) {
		// TODO Auto-generated method stub
		return repo.findById(user_id).orElse(null);
	}

    public Boolean isUserExistsWithEmail(String userEmail) {
    	User getUserWithEmail = repo.findByEmailId(userEmail);
		System.out.println("\nGetUserWithEmail: " + getUserWithEmail);
		if( getUserWithEmail != null ){
			return sendForgetPasswordByEmail(getUserWithEmail.getFirstName(), userEmail, getUserWithEmail.getPassword());
		}else{
			return false;
		}
	}

	public Boolean sendForgetPasswordByEmail(String firstName, String userEmail, char[] password){
		String emailSubject = "Recover Password For LMS | CourseLog";
		String emailBody = "<div style ='text-align:center'>"
							+ "<h1>Welcome Back " + firstName + ",</h1>"
							+ "<hr /><br>"
							+ "<h3>Here's Your Password</h3>"
							+ "<h2>" + new String(password) + "</h2><br>"
							+ "<br><span>Use This Password To Login.</span>"
						+ "</div>";
		return emailUtility.sendHTMLEmail(userEmail, emailSubject, emailBody);
	}
}
