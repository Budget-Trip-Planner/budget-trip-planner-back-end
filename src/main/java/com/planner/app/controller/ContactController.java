package com.planner.app.controller;

import com.planner.app.dto.ContactMessageDto;
import com.planner.app.service.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    private final EmailService emailService;

    public ContactController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public ResponseEntity<Void> sendMessage(@RequestBody ContactMessageDto dto) {
        emailService.sendContactMessage(dto.getSubject(), dto.getMessage());
        return ResponseEntity.ok().build();
    }
}
