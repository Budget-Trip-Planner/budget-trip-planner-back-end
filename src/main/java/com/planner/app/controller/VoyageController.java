package com.planner.app.controller;

import com.planner.app.dto.ProposalDTO;
import com.planner.app.dto.VoyageDTO;
import com.planner.app.entity.Voyage;
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

    @GetMapping
    public ResponseEntity<List<Voyage>> getAllVoyages() {
        List<Voyage> voyages = voyageService.getAllVoyages();
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
            Voyage newvoyage = new Voyage();
            newvoyage.setObjectType(voyageDTO.getObjectType());
            newvoyage.setObjectId(voyageDTO.getObjectId());
            newvoyage.setDestination(voyageDTO.getDestination());
            newvoyage.setBudgetTotal(voyageDTO.getBudgetTotal());
            newvoyage.setDurationDays(voyageDTO.getDurationDays());
            newvoyage.setStartDate(voyageDTO.getStartDate());
            newvoyage.setCoverImage(voyageDTO.getCoverImage());

            Voyage voyage = voyageService.createVoyage(newvoyage);
            return ResponseEntity.status(HttpStatus.CREATED).body(voyage);
        } catch ( RuntimeException e ) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
