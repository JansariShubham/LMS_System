package com.spring.lms.utility;

public interface EmailUtility {
    public boolean sendEmail(String emailTo, String emailSubject, String emailBody);
}
