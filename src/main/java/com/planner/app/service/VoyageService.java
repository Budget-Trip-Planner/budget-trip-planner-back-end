package com.planner.app.service;

import com.planner.app.dao.ExpenseRepository;
import com.planner.app.dao.ItineraryRepository;
import com.planner.app.dao.VoyageRepository;
import com.planner.app.dto.ProposalDTO;
import com.planner.app.entity.Expense;
import com.planner.app.entity.Itinerary;
import com.planner.app.entity.Voyage;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List; 
import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class VoyageService {

    private final VoyageRepository voyageRepository;
    private final ExpenseRepository expenseRepository;
    private final ItineraryRepository itineraryRepository;

    @Transactional
    public ProposalDTO getVoyageById(Integer id) {
        Expense expense = null;
        List<Itinerary> itineraries = null;
        Voyage voyage = voyageRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Voyage not found with id: {}", id);
                    return new RuntimeException("Voyage not found with id: " + id);
                });
        expense = expenseRepository.findByVoyageId(id).orElse(null);
        itineraries = itineraryRepository.findByVoyageIdOrderByDayNumberAsc(id).orElse(null);

        return mapToProposalDTO(voyage, expense, itineraries);
    }

    @Transactional
    public Voyage getVoyageById(Integer id) {
        return voyageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Voyage not found with id " + id));
    public List<Voyage> getAllVoyagesByBudgetAndByDestination(BigDecimal budget, String destination) {
        return voyageRepository.findByBudgetAndDestination(budget, destination);
    }

    @Transactional
    public List<Voyage> getAllVoyages() {
        return voyageRepository.findAll();
    }

    @Transactional
    public Voyage createVoyage(Voyage voyage) {
        return voyageRepository.save(voyage);
    }

    // Nouvelle methode pour recuperer les voyages d'un utilisateur
    @Transactional
    public List<Voyage> getVoyagesByUserId(Integer userId) {
        return voyageRepository.findByUserId(userId);
    }



    private ProposalDTO mapToProposalDTO(Voyage voyage, Expense expense, List<Itinerary> itineraries) {
        ProposalDTO proposalDTO = new ProposalDTO();
        proposalDTO.setId(voyage.getId());
        proposalDTO.setObjectType(voyage.getObjectType());
        proposalDTO.setObjectId(voyage.getObjectId());
        proposalDTO.setDestination(voyage.getDestination());
        proposalDTO.setBudgetTotal(voyage.getBudgetTotal());
        proposalDTO.setDurationDays(voyage.getDurationDays());
        proposalDTO.setStartDate(voyage.getStartDate());
        proposalDTO.setCreatedAt(voyage.getCreatedAt());
        proposalDTO.setCoverImage(voyage.getCoverImage());
        proposalDTO.setExpense(expense);
        proposalDTO.setItineraries(itineraries);
        return proposalDTO;
    }
}
