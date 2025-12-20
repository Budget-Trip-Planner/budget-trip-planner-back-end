package com.planner.app.service;

import com.planner.app.dao.UserRepository;
import com.planner.app.dao.LocationRepository;
import com.planner.app.dao.ImageRepository;
import com.planner.app.dto.UserResponseDTO;
import com.planner.app.entity.Image;
import com.planner.app.entity.Location;
import com.planner.app.entity.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final LocationRepository locationRepository;
    private final ImageRepository imageRepository;

    private static final SimpleDateFormat ISO_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public UserResponseDTO getUserProfile(Long userId) {
        User user = userRepository.findById(userId.intValue())
                .orElseThrow(() -> new RuntimeException("User not found"));
        return convertToResponseDTO(user);
    }

    public UserResponseDTO updateUserProfile(Long userId, UserResponseDTO userDto) {
        User user = userRepository.findById(userId.intValue())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Mettre à jour les champs simples
        user.setLastName(userDto.getLastName());
        user.setFirstName(userDto.getFirstName());
        user.setUsername(userDto.getUsername());
        user.setMail(userDto.getMail());
        user.setPhoneNumber(userDto.getPhoneNumber());

        // Convertir la date string en Date
        if (userDto.getBirthday() != null) {
            try {
                user.setBirthday(ISO_DATE_FORMAT.parse(userDto.getBirthday()));
            } catch (ParseException e) {
                log.warn("Invalid date format for birthday: {}", userDto.getBirthday());
            }
        }

        // Mettre à jour la location
        if (userDto.getLocation() != null) {
            Location location = user.getLocation_id();
            if (location == null) {
                location = new Location();
            }
            location.setCity(userDto.getLocation().getCity());
            location.setCountry(userDto.getLocation().getCountry());
            location = locationRepository.save(location);
            user.setLocation_id(location);
        }

        // Mettre à jour l'image si une nouvelle URL est fournie
        if (userDto.getImageUrl() != null && !userDto.getImageUrl().isEmpty()) {
            Image image = user.getProfile_image_id();
            if (image == null) {
                image = new Image();
                image.setObjectType("users");
                image.setObjectId(user.getId());
            }
            image.setUrl(userDto.getImageUrl());
            image = imageRepository.save(image);
            user.setProfile_image_id(image);
        }

        userRepository.save(user);

        return convertToResponseDTO(user);
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