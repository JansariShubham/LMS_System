package com.spring.lms.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailUtilityImpl implements EmailUtility
{
    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String emailFrom;
    @Override
    public boolean sendEmail(String emailTo, String emailSubject, String emailBody) {

        try{
            System.out.println("\nUser From Email: " + this.emailFrom);
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(this.emailFrom);
            simpleMailMessage.setTo(emailTo);
            simpleMailMessage.setSubject(emailSubject);
            simpleMailMessage.setText(emailBody);
            javaMailSender.send(simpleMailMessage);
            System.out.println("\nEmail Sent...\n");
            return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("\nError occured while sending email: " + e.getMessage());
        }
        return false;
    }
}
