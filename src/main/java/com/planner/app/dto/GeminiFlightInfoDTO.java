package com.planner.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class GeminiFlightInfoDTO {
    private String airline;
    private String flightNumber;
    private GeminiAirportDTO departureAirport;
    private GeminiAirportDTO arrivalAirport;
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;
    private String duration;

    @JsonProperty("class")
    private String flightClass;

    private Integer stops;
}
