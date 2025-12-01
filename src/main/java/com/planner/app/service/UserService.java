package com.planner.app.service;

import com.planner.app.dao.UserRepository;
import com.planner.app.dao.LocationRepository;
import com.planner.app.dao.ImageRepository;
import com.planner.app.dto.UserDTO;
import com.planner.app.dto.ImageDTO;
import com.planner.app.dto.LocationDTO;
import com.planner.app.entity.Image;
import com.planner.app.entity.Location;
import com.planner.app.entity.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final LocationRepository locationRepository;
    private final ImageRepository imageRepository;

    public UserDTO getUserProfile(Long userId) {
        User user = userRepository.findById(userId.intValue())
                .orElseThrow(() -> new RuntimeException("User not found"));

        UserDTO dto = new UserDTO();
        dto.setLastName(user.getLastName());
        dto.setFirstName(user.getFirstName());
        dto.setUsername(user.getUsername());
        dto.setMail(user.getMail());
        dto.setPhoneNumber(user.getPhoneNumber());
        dto.setBirthday(user.getBirthday());

        // Image -> ImageDTO
        if (user.getProfile_image_id() != null) {
            Image img = user.getProfile_image_id();
            ImageDTO imgDto = new ImageDTO();
            imgDto.setId(img.getId());
            imgDto.setUrl(img.getUrl());
            imgDto.setObjectType(img.getObjectType());
            imgDto.setObjectId(img.getObjectId());
            dto.setImage(imgDto);
        }

        // Location -> LocationDTO
        if (user.getLocation_id() != null) {
            Location loc = user.getLocation_id();
            LocationDTO locDto = new LocationDTO();
            locDto.setId(loc.getId());
            locDto.setCity(loc.getCity());
            locDto.setCountry(loc.getCountry());
            dto.setLocation(locDto);
        }

        return dto;
    }


    public UserDTO updateUserProfile(Long userId, UserDTO userDto) {
        User user = userRepository.findById(userId.intValue())
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setLastName(userDto.getLastName());
        user.setFirstName(userDto.getFirstName());
        user.setUsername(userDto.getUsername());
        user.setMail(userDto.getMail());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setBirthday(userDto.getBirthday());

        // Update location
        if (userDto.getLocation() != null) {
            Location loc = locationRepository.findById(userDto.getLocation().getId())
                    .orElseThrow(() -> new RuntimeException("Location not found"));
            user.setLocation_id(loc);
        }

        // Update image
        if (userDto.getImage() != null) {
            Image img = imageRepository.findById(userDto.getImage().getId())
                    .orElseThrow(() -> new RuntimeException("Image not found"));
            user.setProfile_image_id(img);
        }

        userRepository.save(user);
        return userDto;
    }
}
