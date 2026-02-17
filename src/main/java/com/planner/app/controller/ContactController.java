package com.planner.app.controller;

import com.planner.app.dto.ContactMessageDto;
import com.planner.app.service.EmailService;
import com.planner.app.service.api.CustomUserDetailsService.CustomUserPrincipal;
import com.planner.app.dao.UserRepository;
import com.planner.app.entity.User;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    private final EmailService emailService;
    private final UserRepository userRepository;

    public ContactController(EmailService emailService,
                             UserRepository userRepository) {
        this.emailService = emailService;
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<Void> sendMessage(
            @Valid @RequestBody ContactMessageDto dto,
            Authentication authentication) {

        CustomUserPrincipal principal =
                (CustomUserPrincipal) authentication.getPrincipal();

        User user = userRepository.findById(principal.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        emailService.sendContactMessage(dto, user);

        return ResponseEntity.ok().build();
    }
}
