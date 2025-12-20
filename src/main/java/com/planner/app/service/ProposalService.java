package com.planner.app.service;

import com.planner.app.dao.VoyageRepository;
import com.planner.app.dto.LocationDTO;
import com.planner.app.dto.TripRequestDTO;
import com.planner.app.dto.TripResponseDTO;
import com.planner.app.entity.Location;
import com.planner.app.entity.Voyage;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ProposalService {

    private final VoyageRepository voyageRepository;

    // Generate travel proposals from database based on user criteria
    public List<TripResponseDTO> generateProposals(TripRequestDTO request) {
        log.info("Searching proposals for budget: {}, duration: {}, departure: {}",
                request.getBudget(), request.getDuration(), request.getDepartureCity());

        List<Voyage> voyages = voyageRepository.findProposals(
                BigDecimal.valueOf(request.getBudget()),
                request.getDuration(),
                request.getDepartureCity()
        );

        LocalDate startDate = request.getStartDate() != null
                ? request.getStartDate()
                : LocalDate.now().plusDays(30);

        return voyages.stream()
                .map(voyage -> mapToTripResponse(voyage, startDate))
                .collect(Collectors.toList());
    }

    private TripResponseDTO mapToTripResponse(Voyage voyage, LocalDate startDate) {
        return TripResponseDTO.builder()
                // Extract the city name string instead of the whole location object
                .destination(voyage.getDestination().getCity())
                .estimatedCost(voyage.getBudgetTotal().doubleValue())
                .startDate(startDate)
                .endDate(startDate.plusDays(voyage.getDurationDays()))
                .durationDays(voyage.getDurationDays())
                .image(voyage.getCoverImage() != null ? voyage.getCoverImage().getUrl() : null)
                .build();
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
}