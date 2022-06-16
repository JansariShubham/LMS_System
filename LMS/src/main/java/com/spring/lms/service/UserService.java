package com.spring.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.lms.model.User;
import com.spring.lms.repository.RegistartionRepo;

@Service
public class UserService {

	@Autowired
	RegistartionRepo repo;
	
	public User signUp(User user) {
		
		if(repo.findByEmailId(user.getEmailId()) != null)
		{
			System.out.println("User is all ready exist!!");
			return null;
		}
		
		return repo.save(user);
	}

	public User login(User user) {
		
		User tempUser = repo.findByEmailId(user.getEmailId());
		//System.out.println(tempUser);
		//System.out.println(tempUser.getPassword());
		//System.out.println(user.getPassword());
	
		if(tempUser != null)
		{
			if(tempUser.getPassword().matches(user.getPassword()))
			{
				
				System.out.println("login success!!");
				return tempUser;
			}
			
			else
			{
				System.out.println("login failed!!");
				return null;
			}
		}
		return tempUser;
		
		
	
		
		
	}

}
