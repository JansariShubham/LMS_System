package com.spring.lms.utility;

import com.spring.lms.service.CourseService;
import com.spring.lms.service.NewsLetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class NewsLetterUtility {
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String emailFrom;

    @Autowired
    private NewsLetterService newsLetterService;

    @Autowired
    private CourseService courseService;

    public void sendNewsLetterUpdateEmail(){
        List<String> list_of_receiver = new LinkedList<>();
        List<String> list_of_user = ;
    }

}
