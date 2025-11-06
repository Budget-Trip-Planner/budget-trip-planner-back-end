package com.planner.app.dto;

import com.planner.app.entity.Expense;
import com.planner.app.entity.Image;
import com.planner.app.entity.Itinerary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProposalDTO {
    private Integer id;
    private String objectType;
    private Integer objectId;
    private String destination;
    private BigDecimal budgetTotal;
    private Integer durationDays;
    private LocalDate startDate;
    private OffsetDateTime createdAt;
    private Image coverImage;
    private Expense expense;
    private List<Itinerary> itineraries;

}