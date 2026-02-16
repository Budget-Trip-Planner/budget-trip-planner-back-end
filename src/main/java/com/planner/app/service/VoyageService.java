package com.planner.app.service;

import com.planner.app.dao.ExpenseRepository;
import com.planner.app.dao.ItineraryRepository;
import com.planner.app.dao.LocationsRepository;
import com.planner.app.dao.VoyageRepository;
import com.planner.app.dto.ProposalDTO;
import com.planner.app.entity.Expense;
import com.planner.app.entity.Itinerary;
import com.planner.app.entity.Locations;
import com.planner.app.entity.Voyage;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class VoyageService {

    private final VoyageRepository voyageRepository;
    private final ExpenseRepository expenseRepository;
    private final ItineraryRepository itineraryRepository;

    /**
     * Get voyage with full details (expense + itineraries) as ProposalDTO
     */
    @Transactional
    public ProposalDTO getVoyageWithDetails(Integer id) {
        Voyage voyage = voyageRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Voyage not found with id: {}", id);
                    return new RuntimeException("Voyage not found with id: " + id);
                });

        Expense expense = expenseRepository.findByVoyageId(id).orElse(null);
        List<Itinerary> itineraries = itineraryRepository.findByVoyageIdOrderByDayNumberAsc(id).orElse(null);

        return mapToProposalDTO(voyage, expense, itineraries);
    }

    /**
     * Get voyage entity by ID
     */
    @Transactional
    public Voyage getVoyageById(Integer id) {
        return voyageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Voyage not found with id: " + id));
    }

    /**
     * Search voyages by budget and destination
     */
    @Transactional
    public List<Voyage> getAllVoyagesByBudgetAndByDestination(BigDecimal budget, String destination) {
        return voyageRepository.findByBudgetAndDestination(budget, destination);
    }

    /**
     * Get all voyages
     */
    @Transactional
    public List<Voyage> getAllVoyages() {
        return voyageRepository.findAll();
    }

    /**
     * Create a new voyage
     */
    @Transactional
    public Voyage createVoyage(Voyage voyage) {
        return voyageRepository.save(voyage);
    }

    /**
     * Get voyages by user ID
     */
    @Transactional
    public List<Voyage> getVoyagesByUserId(Integer userId) {
        return voyageRepository.findByUserId(userId);
    }

    /**
     * Map Voyage entity to ProposalDTO
     */
    private ProposalDTO mapToProposalDTO(Voyage voyage, Expense expense, List<Itinerary> itineraries) {
        ProposalDTO proposalDTO = new ProposalDTO();
        proposalDTO.setId(voyage.getId());
        proposalDTO.setObjectType(voyage.getObjectType());
        proposalDTO.setObjectId(voyage.getObjectId());
        proposalDTO.setDeparture(voyage.getDeparture());
        proposalDTO.setDestination(voyage.getDestination());
        proposalDTO.setBudgetTotal(voyage.getBudgetTotal());
        proposalDTO.setDurationDays(voyage.getDurationDays());
        proposalDTO.setStartDate(voyage.getStartDate());
        proposalDTO.setHotel(voyage.getHotel());
        proposalDTO.setCreatedAt(voyage.getCreatedAt());
        proposalDTO.setCoverImage(voyage.getCoverImage());
        proposalDTO.setExpense(expense);
        proposalDTO.setItineraries(itineraries);
        return proposalDTO;
    }
}