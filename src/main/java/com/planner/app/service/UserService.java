package com.planner.app.service;

import com.planner.app.dao.UserRepository;
import com.planner.app.dto.UserDTO;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Transactional
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserDTO getUserByUsername(String username) {
        try{
            UserDTO userDTO = userRepository.findByUsername(username);
            return userDTO;
        } catch (Exception e) {
            log.error("Error retrieving user with username: {}", username, e);
            throw new RuntimeException("Error retrieving user: " + e.getMessage(), e);
        }
    }

}
