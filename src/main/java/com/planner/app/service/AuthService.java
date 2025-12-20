package com.planner.app.service;

import com.planner.app.auth.api.dto.LoginDTO;
import com.planner.app.auth.api.dto.LoginResponseDTO;
import com.planner.app.auth.api.dto.RegisterRequest;
import com.planner.app.auth.jwt.JwtUtil;
import com.planner.app.dao.LocationRepository;
import com.planner.app.dao.UserRepository;
import com.planner.app.dto.UserResponseDTO;
import com.planner.app.entity.Location;
import com.planner.app.entity.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final UserRepository userRepository;
    private final LocationRepository locationRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    private static final SimpleDateFormat ISO_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Transactional
    public LoginResponseDTO login(LoginDTO request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );

            String token = jwtUtil.generateToken(request.getUsername());

            // Récupérer l'entité User complète pour avoir l'ID et toutes les infos
            User user = userRepository.findByUsernameOrEmail(request.getUsername())
                    .orElseThrow(() -> new RuntimeException("User not found after authentication"));

            UserResponseDTO userDTO = convertToResponseDTO(user);

            return LoginResponseDTO.builder()
                    .token(token)
                    .userId(user.getId())
                    .email(user.getMail())
                    .user(userDTO)
                    .message("Login successful")
                    .build();

        } catch (BadCredentialsException e) {
            log.error("Invalid credentials for user: {}", request.getUsername());
            throw new RuntimeException("Invalid username or password");
        }
    }

    @Transactional
    public LoginResponseDTO register(RegisterRequest request) {

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        if (userRepository.existsByMail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        // Créer la location si city/country fournis
        Location location = null;
        if (request.getCity() != null && request.getCountry() != null) {
            location = new Location();
            location.setCity(request.getCity());
            location.setCountry(request.getCountry());
            location = locationRepository.save(location);
        }

        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setUsername(request.getUsername());
        user.setMail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setBirthday(request.getBirthday());
        user.setLocation_id(location);

        User savedUser = userRepository.save(user);

        // Générer le token pour auto-login après inscription
        String token = jwtUtil.generateToken(savedUser.getUsername());

        UserResponseDTO userDTO = convertToResponseDTO(savedUser);

        return LoginResponseDTO.builder()
                .token(token)
                .userId(savedUser.getId())
                .email(savedUser.getMail())
                .user(userDTO)
                .message("Registration successful")
                .build();
    }

    /**
     * Convertit une entité User vers le DTO simplifié pour le frontend
     */
    private UserResponseDTO convertToResponseDTO(User user) {
        UserResponseDTO.UserResponseDTOBuilder builder = UserResponseDTO.builder()
                .lastName(user.getLastName())
                .firstName(user.getFirstName())
                .username(user.getUsername())
                .mail(user.getMail())
                .phoneNumber(user.getPhoneNumber());

        // Convertir la date en string ISO 8601
        if (user.getBirthday() != null) {
            builder.birthday(ISO_DATE_FORMAT.format(user.getBirthday()));
        }

        // Convertir la location
        if (user.getLocation_id() != null) {
            builder.location(UserResponseDTO.LocationSimpleDTO.builder()
                    .city(user.getLocation_id().getCity())
                    .country(user.getLocation_id().getCountry())
                    .build());
        }

        // Convertir l'image en URL simple
        if (user.getProfile_image_id() != null) {
            builder.imageUrl(user.getProfile_image_id().getUrl());
        }

        return builder.build();
    }
}