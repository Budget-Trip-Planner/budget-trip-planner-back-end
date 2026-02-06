package com.planner.app.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.planner.app.dto.ProposalDTO;
import com.planner.app.dto.TripRequestDTO;
import com.planner.app.entity.Voyage;
import com.planner.app.service.GeminiService;
import com.planner.app.service.ProposalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/proposals")
@RequiredArgsConstructor
@Slf4j
public class ProposalController {

    private final ProposalService proposalService;
    private final GeminiService geminiService;

    // Get the current authenticated user's ID from the security context
    private Integer getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof com.planner.app.service.api.CustomUserDetailsService.CustomUserPrincipal principal) {
            return principal.getUserId();
        }
        return null;
    }

    @PostMapping("/generate")
    public ResponseEntity<?> getProposals(@RequestBody TripRequestDTO request) {
        try {
            log.info("Generating proposals: {}", request);
            JsonNode proposals = geminiService.generateTravelProposals(request);
            return ResponseEntity.ok(proposals);
        } catch (Exception e) {
            log.error("Error generating proposals: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", e.getMessage(), "type", e.getClass().getSimpleName()));
        }
    }

    @PostMapping
    public ResponseEntity<?> saveProposal(@RequestBody ProposalDTO proposalDTO) {
        try {
            Integer userId = getCurrentUserId();
            log.info("Received proposal: destination={}, budget={}, duration={}, userId={}",
                    proposalDTO.getDestination() != null ? proposalDTO.getDestination().getCity() : "null",
                    proposalDTO.getBudgetTotal(),
                    proposalDTO.getDurationDays(),
                    userId);

            Voyage savedVoyage = proposalService.saveProposal(proposalDTO, userId);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedVoyage);
        } catch (Exception e) {
            log.error("Error saving proposal: {}", e.getMessage(), e);
            // Return the error message in the response for debugging
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", e.getMessage(), "type", e.getClass().getSimpleName()));
        }
    }

}
