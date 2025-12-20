package com.planner.app.auth.api.dto;

import com.planner.app.dto.UserResponseDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDTO {
    private String token;
    private Integer userId;
    private String email;
    private String message;
    private UserResponseDTO user;
}