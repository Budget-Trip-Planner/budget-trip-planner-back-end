package com.planner.app.dto;

import com.planner.app.entity.Image;
import com.planner.app.entity.Voyage;
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
    private String objectType;
    private Integer objectId;
    private String destination;
    private BigDecimal budgetTotal;
    private Integer durationDays;
    private LocalDate startDate;
    private OffsetDateTime createdAt = OffsetDateTime.now();
    private Image coverImage;

    public VoyageDTO(String objectType, Integer objectId, String destination, BigDecimal budgetTotal, Integer durationDays, LocalDate startDate, Image coverImage) {
        this.objectType = objectType;
        this.objectId = objectId;
        this.destination = destination;
        this.budgetTotal = budgetTotal;
        this.durationDays = durationDays;
        this.startDate = startDate;
        this.coverImage = coverImage;
        this.createdAt = OffsetDateTime.now();
    }

    public void setObjectType(String objectType) { this.objectType = objectType; }

    public void setObjectId(Integer objectId) { this.objectId = objectId; }

    public void setDestination(String destination) { this.destination = destination; }

    public void setBudgetTotal(BigDecimal budgetTotal) { this.budgetTotal = budgetTotal; }

    public void setDurationDays(Integer durationDays) { this.durationDays = durationDays; }

    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public void setCreatedAt(OffsetDateTime createdAt) { this.createdAt = createdAt; }

    public void setCoverImage(Image coverImage) { this.coverImage = coverImage; }

    public String getObjectType() { return this.objectType; }

    public Integer getObjectId() { return this.objectId; }

    public String getDestination() { return this.destination; }

    public BigDecimal getBudgetTotal() { return this.budgetTotal; }

    public Integer getDurationDays() { return this.durationDays; }

    public LocalDate getStartDate() { return this.startDate; }

    public Image getCoverImage() { return this.coverImage; }

}
