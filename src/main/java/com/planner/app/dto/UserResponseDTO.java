package com.planner.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {
    private String lastName;
    private String firstName;
    private String username;
    private String mail;
    private String phoneNumber;
    private String birthday;  // Format ISO 8601 string
    private LocationSimpleDTO location;
    private String imageUrl;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LocationSimpleDTO {
        private String city;
        private String country;
    }
}
