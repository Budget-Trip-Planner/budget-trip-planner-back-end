package com.planner.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TripResponseDTO {
    private String destination;
    private Double estimatedCost;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer durationDays;
    private String image;
}