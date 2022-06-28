package com.spring.lms.controller;

import com.spring.lms.model.User;
import com.spring.lms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/user")
	public List<User> getUsers()
	{
		return userService.getUserList();
	}
	
	@GetMapping("/user/{user_id}")
	public User getUserById(@PathVariable int user_id)
	{
		return userService.getUserDataById(user_id);
	}
	
	@DeleteMapping("/user/{user_id}")
	public String deleteUser(@PathVariable int user_id)
	{
		return userService.deleteUserData(user_id);
	}
	
	
	@PutMapping("/user")
	public User updateUser(@RequestBody User user)
	{
		return userService.updateUserData(user);
	}

	@GetMapping("/user/forget_password/{userEmail}")
	public Boolean forgotPassword(@PathVariable("userEmail") String userEmail){
		System.out.println("\nUser Email: " + userEmail);
		Boolean isUserExists = userService.isUserExistsWithEmail(userEmail);
		return isUserExists;
	}

}
