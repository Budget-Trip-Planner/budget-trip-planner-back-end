package com.planner.app.dto;

import com.planner.app.entity.Image;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoyageDTO {
    private Integer id;
    private String objectType;
    private Integer objectId;
    private LocationDTO departure;
    private LocationDTO destination;
    private BigDecimal budgetTotal;
    private Integer durationDays;
    private LocalDate startDate;
    private String hotel;
    private OffsetDateTime createdAt;
    private Image coverImage;

    public VoyageDTO(String objectType, Integer objectId, LocationDTO departure, LocationDTO destination,
                     BigDecimal budgetTotal, Integer durationDays, LocalDate startDate, String hotel, Image coverImage) {
        this.objectType = objectType;
        this.objectId = objectId;
        this.departure = departure;
        this.destination = destination;
        this.budgetTotal = budgetTotal;
        this.durationDays = durationDays;
        this.startDate = startDate;
        this.hotel = hotel;
        this.coverImage = coverImage;
        this.createdAt = OffsetDateTime.now();
    }
}