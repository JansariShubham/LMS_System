package com.spring.lms;

//import java.time.LocalDate;
//import java.util.Date;

import com.spring.lms.utility.EmailUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.spring.lms.model.Chapters;
//import com.spring.lms.model.Course;

@SpringBootApplication
public class LmsApplication {

	private static EmailUtility utility;

	@Autowired
	public void setUtility(EmailUtility util){
		utility = util;
		System.out.println("\nSetter injection");
	}

	public static void main(String[] args) {
		SpringApplication.run(LmsApplication.class, args);
		System.out.println("Application started...");
		utility.sendEmail("sunnyvachheta89@gmail.com", "This is test email", "Hello there....");
	}

}
