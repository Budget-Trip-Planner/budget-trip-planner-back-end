package com.planner.app.controller;

import com.planner.app.dto.ProposalDTO;
import com.planner.app.dto.VoyageDTO;
import com.planner.app.entity.Voyage;
import com.planner.app.mapper.VoyageMapper;
import com.planner.app.service.VoyageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/voyages")
@RequiredArgsConstructor
public class VoyageController {
    private final VoyageService voyageService;
    private final VoyageMapper voyageMapper;

    @GetMapping
    public ResponseEntity<List<VoyageDTO>> getAllVoyages() {
        List<VoyageDTO> voyages = voyageService.getAllVoyages().stream().map(voyageMapper::toDTO).toList();
        return ResponseEntity.ok(voyages);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Voyage>> getVoyages(@RequestParam BigDecimal budget, @RequestParam String destination) {
        List<Voyage> voyages = voyageService.getAllVoyagesByBudgetAndByDestination(budget, destination);
        return ResponseEntity.ok(voyages);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProposalDTO> getVoyage(@PathVariable Integer id) {
        try {
            ProposalDTO proposal = voyageService.getVoyageById(id);
            return ResponseEntity.ok(proposal);
        } catch ( RuntimeException e ) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Voyage> createVoyage(@RequestBody VoyageDTO voyageDTO) {
        try {
            Voyage voyage = voyageMapper.toEntity(voyageDTO);
            Voyage savedVoyage = voyageService.createVoyage(voyage);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedVoyage);
        } catch ( RuntimeException e ) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
