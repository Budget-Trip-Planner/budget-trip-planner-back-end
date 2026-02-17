package com.planner.app.service;

import com.planner.app.dto.ContactMessageDto;
import com.planner.app.entity.User;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendContactMessage(ContactMessageDto dto, User user) {

        SimpleMailMessage mail = new SimpleMailMessage();

        mail.setTo("admin@planner.com");
        mail.setSubject(dto.getSubject());
        mail.setReplyTo(user.getMail());

        mail.setText(
                "Nouvelle demande de contact\n\n" +
                        "ID utilisateur : " + user.getId() + "\n" +
                        "Nom : " + user.getFirstName() + "\n" +
                        "Prénom : " + user.getLastName() + "\n" +
                        "Username : " + user.getUsername() + "\n" +
                        "Email : " + user.getMail() + "\n\n" +
                        "Message :\n" +
                        dto.getMessage()
        );

        mail.setFrom("noreply@planner.com");

        mailSender.send(mail);
    }

}
