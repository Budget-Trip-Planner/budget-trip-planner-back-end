package com.planner.app.service;

import com.planner.app.dao.ExpenseRepository;
import com.planner.app.dao.ItineraryRepository;
import com.planner.app.dao.LocationsRepository;
import com.planner.app.dao.UserRepository;
import com.planner.app.dao.VoyageRepository;
import com.planner.app.dto.ProposalDTO;
import com.planner.app.entity.Expense;
import com.planner.app.entity.Itinerary;
import com.planner.app.entity.Locations;
import com.planner.app.entity.User;
import com.planner.app.entity.Voyage;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ProposalService {

    private final LocationsRepository locationRepository;
    private final UserRepository userRepository;
    private final ExpenseRepository expenseRepository;
    private final ItineraryRepository itineraryRepository;
    private final VoyageRepository voyageRepository;

    @Transactional
    public Voyage saveProposal(ProposalDTO proposalDTO, Integer userId) {
        log.info("Saving proposal for destination: {}, userId: {}",
                proposalDTO.getDestination() != null ? proposalDTO.getDestination().getCity() : "unknown",
                userId);

        // 1. Handle locations - find existing or create new
        Locations departure = saveOrGetLocation(proposalDTO.getDeparture());
        Locations destination = saveOrGetLocation(proposalDTO.getDestination());

        // 2. Create and save Voyage
        Voyage voyage = new Voyage();

        // Determine object_type: must be 'users' or 'travel_groups' per database
        // constraint
        String objectType = proposalDTO.getObjectType();
        if (objectType == null || (!objectType.equals("users") && !objectType.equals("travel_groups"))) {
            // Default to 'users' for individual user proposals
            objectType = "users";
        }
        voyage.setObjectType(objectType);

        // Set object_id: use provided value, or userId if object_type is 'users'
        Integer objectId = proposalDTO.getObjectId();
        if (objectId == null) {
            if ("users".equals(objectType) && userId != null) {
                objectId = userId;
            } else {
                throw new IllegalArgumentException("object_id is required for object_type: " + objectType);
            }
        }
        voyage.setObjectId(objectId);

        voyage.setDeparture(departure);
        voyage.setDestination(destination);
        voyage.setBudgetTotal(proposalDTO.getBudgetTotal());
        voyage.setDurationDays(proposalDTO.getDurationDays());
        voyage.setStartDate(proposalDTO.getStartDate());
        voyage.setHotel(proposalDTO.getHotel());
        voyage.setCoverImage(proposalDTO.getCoverImage());

        // Set the creator (user_id) on the voyage
        if (userId != null) {
            User creator = userRepository.findById(userId).orElse(null);
            voyage.setCreator(creator);
        }

        Voyage savedVoyage = voyageRepository.save(voyage);
        log.info("Saved voyage with ID: {}", savedVoyage.getId());

        // 3. Save Expense if exists
        if (proposalDTO.getExpense() != null) {
            Expense expense = proposalDTO.getExpense();
            expense.setId(null); // Ensure it's a new entity
            expense.setVoyage(savedVoyage);
            expenseRepository.save(expense);
            log.info("Saved expense for voyage ID: {}", savedVoyage.getId());
        }

        // 4. Save Itineraries - group activities by day to handle multiple activities
        // per day
        if (proposalDTO.getItineraries() != null && !proposalDTO.getItineraries().isEmpty()) {
            // Group activities by day number and concatenate them
            Map<Integer, String> activitiesByDay = proposalDTO.getItineraries().stream()
                    .collect(Collectors.groupingBy(
                            Itinerary::getDayNumber,
                            Collectors.mapping(Itinerary::getActivity, Collectors.joining(" | "))));

            // Create one itinerary entry per day
            for (Map.Entry<Integer, String> entry : activitiesByDay.entrySet()) {
                Itinerary itinerary = new Itinerary();
                itinerary.setVoyage(savedVoyage);
                itinerary.setDayNumber(entry.getKey());
                itinerary.setActivity(entry.getValue());
                itineraryRepository.save(itinerary);
            }
            log.info("Saved {} itinerary days for voyage ID: {}", activitiesByDay.size(), savedVoyage.getId());
        }

        return savedVoyage;
    }

    /**
     * Find existing location by city and country, or create a new one.
     * Uses findFirst to handle potential duplicate entries in the database.
     */
    private Locations saveOrGetLocation(Locations location) {
        if (location == null) {
            return null;
        }

        // If ID is provided, try to find by ID first
        if (location.getId() != null) {
            return locationRepository.findById(location.getId()).orElse(null);
        }

        // Try to find existing location by city and country
        // Using findFirst to handle potential duplicates in the database
        if (location.getCity() != null && location.getCountry() != null) {
            return locationRepository.findFirstByCityAndCountry(location.getCity(), location.getCountry())
                    .orElseGet(() -> {
                        // Create new location if not found
                        Locations newLocation = new Locations();
                        newLocation.setCity(location.getCity());
                        newLocation.setCountry(location.getCountry());
                        return locationRepository.save(newLocation);
                    });
        }

        return null;
    }
}