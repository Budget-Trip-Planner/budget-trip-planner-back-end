package com.planner.app.mapper;

import com.planner.app.dto.VoyageDTO;
import com.planner.app.entity.Voyage;
import org.springframework.stereotype.Component;

@Component
public class VoyageMapper {

    public VoyageDTO toDTO(Voyage voyage) {
        if (voyage == null) {
            return null;
        }

        VoyageDTO dto = new VoyageDTO();
        dto.setObjectType(voyage.getObjectType());
        dto.setObjectId(voyage.getObjectId());
        dto.setDestination(voyage.getDestination());
        dto.setBudgetTotal(voyage.getBudgetTotal());
        dto.setDurationDays(voyage.getDurationDays());
        dto.setStartDate(voyage.getStartDate());
        dto.setCreatedAt(voyage.getCreatedAt());
        dto.setCoverImage(voyage.getCoverImage());
        return dto;
    }

    public Voyage toEntity(VoyageDTO dto) {
        if (dto == null) {
            return null;
        }

        Voyage voyage = new Voyage();
        voyage.setObjectType(dto.getObjectType());
        voyage.setObjectId(dto.getObjectId());
        voyage.setDestination(dto.getDestination());
        voyage.setBudgetTotal(dto.getBudgetTotal());
        voyage.setDurationDays(dto.getDurationDays());
        voyage.setStartDate(dto.getStartDate());
        voyage.setCoverImage(dto.getCoverImage());
        return voyage;
    }
}