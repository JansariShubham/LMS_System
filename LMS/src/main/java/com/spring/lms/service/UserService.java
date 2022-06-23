package com.spring.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.lms.model.User;
import com.spring.lms.repository.RegistartionRepo;

@Service
public class UserService {

	@Autowired
	RegistartionRepo repo;

	public User signUp(User user) {

		if (repo.findByEmailId(user.getEmailId()) != null) {
			System.out.println("User is all ready exist!!");
			return null;
		}

		return repo.save(user);
	}

	public User login(User user) {

		User tempUser = repo.findByEmailId(user.getEmailId());
//		String emailError = "Invalid Email ID!! ";
//		String passwordError = "Invalid Password!! ";
		// System.out.println(tempUser);
		// System.out.println(tempUser.getPassword());
		// System.out.println(user.getPassword());

		if (tempUser != null) {
			if (tempUser.getPassword().matches(user.getPassword())) {

				System.out.println("login success!!");
				return tempUser;
			}

			else {
				System.out.println("login failed!!");
				return tempUser;
			}
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

		return repo.save(existingUser);
	}

	public String deleteUserData(int user_id) {
		// TODO Auto-generated method stub
		repo.deleteById(user_id);
		return "User Deleted!! " + user_id;
		
	}

	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public User getUserDataById(int user_id) {
		// TODO Auto-generated method stub
		return repo.findById(user_id).orElse(null);
	}

}
