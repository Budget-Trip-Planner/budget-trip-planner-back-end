package com.planner.app.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendContactMessage(String subject, String message) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo("admin@planner.com");
        mail.setSubject(subject);
        mail.setText(message);
        mail.setFrom("noreply@planner.com");

        mailSender.send(mail);
    }
}
