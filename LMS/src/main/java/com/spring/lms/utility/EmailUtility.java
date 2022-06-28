package com.spring.lms.utility;

public interface EmailUtility {
    public boolean sendTextEmail(String emailTo, String emailSubject, String emailBody);
    public boolean sendHTMLEmail(String emailTo, String emailSubject, String emailBody);
}
