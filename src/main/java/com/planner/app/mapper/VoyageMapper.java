package com.planner.app.mapper;

import com.planner.app.dao.LocationRepository;
import com.planner.app.dto.LocationDTO;
import com.planner.app.dto.VoyageDTO;
import com.planner.app.entity.Location;
import com.planner.app.entity.Voyage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VoyageMapper {

    private final LocationRepository locationRepository;

    public VoyageDTO toDTO(Voyage voyage) {
        if (voyage == null) {
            return null;
        }

        VoyageDTO dto = new VoyageDTO();
        dto.setId(voyage.getId());
        dto.setObjectType(voyage.getObjectType());
        dto.setObjectId(voyage.getObjectId());
        dto.setDeparture(toLocationDTO(voyage.getDeparture()));
        dto.setDestination(toLocationDTO(voyage.getDestination()));
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
        voyage.setDeparture(toLocationEntity(dto.getDeparture()));
        voyage.setDestination(toLocationEntity(dto.getDestination()));
        voyage.setBudgetTotal(dto.getBudgetTotal());
        voyage.setDurationDays(dto.getDurationDays());
        voyage.setStartDate(dto.getStartDate());
        voyage.setCoverImage(dto.getCoverImage());
        return voyage;
    }

    private LocationDTO toLocationDTO(Location location) {
        if (location == null) {
            return null;
        }
        LocationDTO dto = new LocationDTO();
        dto.setId(location.getId());
        dto.setCity(location.getCity());
        dto.setCountry(location.getCountry());
        return dto;
    }

    private Location toLocationEntity(LocationDTO dto) {
        if (dto == null) {
            return null;
        }
        // If ID is provided, fetch existing location
        if (dto.getId() != null) {
            return locationRepository.findById(dto.getId()).orElse(null);
        }
        // Otherwise create new location
        Location location = new Location();
        location.setCity(dto.getCity());
        location.setCountry(dto.getCountry());
        return locationRepository.save(location);
    }
}