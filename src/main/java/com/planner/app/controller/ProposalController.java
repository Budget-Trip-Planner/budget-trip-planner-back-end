package com.planner.app.controller;

import com.planner.app.dto.TripRequestDTO;
import com.planner.app.dto.TripResponseDTO;
import com.planner.app.service.ProposalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proposals")
@RequiredArgsConstructor
public class ProposalController {

    private final ProposalService proposalService;

    @PostMapping
    public ResponseEntity<List<TripResponseDTO>> generateProposals(@RequestBody TripRequestDTO request) {
        List<TripResponseDTO> proposals = proposalService.generateProposals(request);
        return ResponseEntity.ok(proposals);
    }

}
