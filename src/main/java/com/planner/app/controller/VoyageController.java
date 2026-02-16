package com.planner.app.controller;

import com.planner.app.dao.UserRepository;
import com.planner.app.dto.ProposalDTO;
import com.planner.app.dto.VoyageDTO;
import com.planner.app.entity.User;
import com.planner.app.entity.Voyage;
import com.planner.app.mapper.VoyageMapper;
import com.planner.app.service.VoyageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/voyages")
@RequiredArgsConstructor
@Slf4j
public class VoyageController {
    private final VoyageService voyageService;
    private final VoyageMapper voyageMapper;
    private final UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<VoyageDTO>> getAllVoyages() {
        List<VoyageDTO> voyages = voyageService.getAllVoyages().stream()
                .map(voyageMapper::toDTO)
                .toList();
        return ResponseEntity.ok(voyages);
    }

    @GetMapping("/search")
    public ResponseEntity<List<VoyageDTO>> getVoyages(
            @RequestParam BigDecimal budget,
            @RequestParam String destination) {
        List<VoyageDTO> voyages = voyageService.getAllVoyagesByBudgetAndByDestination(budget, destination).stream()
                .map(voyageMapper::toDTO)
                .toList();
        return ResponseEntity.ok(voyages);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProposalDTO> getVoyage(@PathVariable Integer id) {
        try {
            ProposalDTO proposal = voyageService.getVoyageWithDetails(id);
            return ResponseEntity.ok(proposal);
        } catch (RuntimeException e) {
            log.error("Error getting voyage {}: {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    private Integer getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof com.planner.app.service.api.CustomUserDetailsService.CustomUserPrincipal principal) {
            return principal.getUserId();
        }
        return null;
    }

    @PostMapping
    public ResponseEntity<Voyage> createVoyage(@RequestBody VoyageDTO voyageDTO) {
        try {
            Voyage voyage = voyageMapper.toEntity(voyageDTO);
            Integer userId = getCurrentUserId();
            if (userId != null) {
                User creator = userRepository.findById(userId).orElse(null);
                voyage.setCreator(creator);
            }
            Voyage savedVoyage = voyageService.createVoyage(voyage);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedVoyage);
        } catch (RuntimeException e) {
            log.error("Error creating voyage: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}