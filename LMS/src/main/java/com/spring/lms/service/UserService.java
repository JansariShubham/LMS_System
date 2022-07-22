package com.spring.lms.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spring.lms.model.Tutor;
import com.spring.lms.model.User;
import com.spring.lms.repository.RegistartionRepo;
import com.spring.lms.repository.TutorRepo;
import com.spring.lms.utility.EmailUtility;
import com.spring.lms.utility.GenerateOTP;
import com.spring.lms.utility.ImageUtility;

//import com.sun.org.apache.xpath.internal.operations.String;

@Service
@Transactional
public class UserService {

	@Autowired
	private RegistartionRepo repo;

	@Autowired
	private TutorRepo tutorRepo;

	@Autowired
	private EmailUtility emailUtility;

	@Autowired
	private NewsLetterService newsLetterService;
	
	@Autowired
	private GenerateOTP genrateOTP;
	
	@Autowired
	private EnrollmentService enrollmentService;
	
	@Autowired
	private CourseService courseService;
	
	public User signUp(User user) {

		if (repo.findByEmailId(user.getEmailId()) != null) {
			System.out.println("User is all ready exist!!");
			return null;
		}
		// NewsLetter Email removal if exists
		if (newsLetterService.checkUserExistsInNewsLetter(user.getEmailId().trim())) {
			newsLetterService.removeUserFromNewsLetter(user.getEmailId().trim());
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
			else {
				if(tempUser.getRole().equalsIgnoreCase("student")) {
					Optional<List<Integer>> list = this.enrollmentService.getMyCourses(tempUser.getUser_id());					
					if(list.isPresent())
						tempUser.setMyCourses(list.get());
				}
				else if(tempUser.getRole().equalsIgnoreCase("tutor")){
					Optional<List<Integer>> list = this.courseService.getMyCourses(tempUser.getUser_id());
					if(list.isPresent())
						tempUser.setMyCourses(list.get());
				}
			}
		} else {
			tempUser = new User();
			System.out.println("---> User doesn't exist...");
			tempUser.setEmailError(true);
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
			// existingUser.setImage(file.getBytes());\
			System.out.println(existingUser.getRole());
			if (existingUser.getRole().equals("student")) {

				existingUser.setRole("tutor");
				tutor.setUser(existingUser);

				tutorRepo.save(tutor);
				return existingUser;

			}

			tutor.setUser(existingUser);
			repo.save(existingUser);
			return null;
		} else {
			System.out.println("hello ,,,");
			// user.setImage(file.getBytes());
			tutor.setUser(user);
			tutorRepo.save(tutor);
			return repo.save(user);

			// return signUp(user);

		}

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
		if (getUserWithEmail != null) {
			return sendForgetPasswordByEmail(getUserWithEmail.getFirstName(), userEmail,
					getUserWithEmail.getPassword());
		} else {
			return false;
		}
	}

	public Boolean sendForgetPasswordByEmail(String firstName, String userEmail, char[] password) {
		String emailSubject = "Recover Password For LMS | CourseLog";
		String emailBody = "<div style ='text-align:center'>" + "<h1>Welcome Back " + firstName + ",</h1>"
				+ "<hr /><br>" + "<h3>Here's Your Password</h3>" + "<h2>" + new String(password) + "</h2><br>"
				+ "<br><span>Use This Password To Login.</span>" + "</div>";
		return emailUtility.sendHTMLEmail(userEmail, emailSubject, emailBody);
	}

	public boolean saveTutorProfileImage(int id, MultipartFile profileImage) throws IOException {
		Optional<User> userObj = repo.findById(id);
		if (userObj.isPresent()) {
			User obj = userObj.get();
			try {
				obj.setProfileImage(ImageUtility.compressImage(profileImage));
				repo.save(obj);
				return true;
			} catch (Exception e) {
				System.out.println("\nError during file upload... " + e.getMessage());
				e.printStackTrace();
				return false;
			}

		} else
			return false;
	}

	public List<String> listAllUserEmailFromUser() {
		return repo.getAllEmailAddressFromUserData();
	}

	public String getFullNameOfUser(int userId) {

		List<List<String>> firstAndLastName = repo.getUserNameUsingId(userId);
		if (firstAndLastName.size() != 0) {
			String firstName = firstAndLastName.get(0).get(0);
			String lastName = firstAndLastName.get(0).get(1);
			return (firstName + " " + lastName);
		}
		return null;
	}

	public String sendOTP(Map<String, String> data) {
		
		String otp = this.genrateOTP.generateOTP(6);
		String emailTo = data.get("emailId");
		String userName = data.get("firstName")+" "+data.get("lastName");
		String emailSubject = "Registration OTP from Itaims";
		String emailBody = "<div style='font-family: Helvetica,Arial,sans-serif;min-width:1000px;overflow:auto;line-height:2\'>"
							+ "  <div style=\"margin:10px 0;width:70%;padding:5px 0\">"
							+ "<div style=\"border-bottom:1px solid #eee\">"
							+ "<a href=\"\" style=\"font-size:1.4em;color: #00466a;text-decoration:none;font-weight:600\">Courselog</a>\r\n"
							+ "</div>"
							+"<p style=\"font-size:1.1em\">Hi, "+userName+"</p>"
							+"<p>Thank you for choosing Courselog. Use the following OTP to complete your Sign Up procedures.</p>"
							+"<h2 style=\"background: #00466a;margin: 0 auto;width: max-content;padding: 0 10px;color: #fff;border-radius: 4px;\">"+otp+"</h2>"
							+"<p style=\"font-size:0.9em;\">Regards,<br />Courselog</p>"
							+"<hr style=\"border:none;border-top:1px solid #eee\" />"
							+"<div style=\"float:right;padding:8px 0;color:#aaa;font-size:1em;line-height:1;font-weight:300\">"
							+"<p>ITAIMS</p>\r\n" 
							+"<p>City Center 2, 605, Science City</p>\r\n" 
							+"<p>Ahmedabad, Gujarat 380060</p>"
							+"</div>\r\n" + 
							"  </div>\r\n" + 
							"</div>";
		boolean result = this.emailUtility.sendHTMLEmail(emailTo, emailSubject, emailBody);
		if(result) {
			return otp;
		}
		return null;
	}
}
