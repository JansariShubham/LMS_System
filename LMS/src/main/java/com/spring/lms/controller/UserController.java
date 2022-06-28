package com.spring.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.lms.model.User;
import com.spring.lms.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	UserService userService;
	
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
	public User deleteUser(@PathVariable int user_id)
	{
		return userService.deleteUserData(user_id);
	}
	
	
	@PutMapping("/user")
	public User updateUser(@RequestBody User user)
	{
		return userService.updateUserData(user);
	}

}
