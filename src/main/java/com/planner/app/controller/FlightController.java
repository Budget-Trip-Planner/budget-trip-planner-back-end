package com.planner.app.controller;

import com.planner.app.dto.FlightDTO;
import com.planner.app.entity.Flight;
import com.planner.app.service.FlightService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class FlightController {

    private final FlightService flightService;

    @GetMapping("/api/voyages/{voyageId}/flights")
    public ResponseEntity<List<Flight>> getFlightsByVoyage(@PathVariable Integer voyageId) {
        List<Flight> flights = flightService.getFlightsByVoyageId(voyageId);
        return ResponseEntity.ok(flights);
    }

    @PostMapping("/api/voyages/{voyageId}/flights")
    public ResponseEntity<?> addFlightToVoyage(@PathVariable Integer voyageId,
                                               @RequestBody FlightDTO dto) {
        try {
            Flight flight = flightService.addFlightToVoyage(voyageId, dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(flight);
        } catch (IllegalStateException e) {
            log.warn("Duplicate flight direction for voyage {}: {}", voyageId, e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (RuntimeException e) {
            log.error("Error adding flight to voyage {}: {}", voyageId, e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/api/flights/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable Integer id) {
        try {
            Flight flight = flightService.getFlightById(id);
            return ResponseEntity.ok(flight);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/api/flights/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Integer id) {
        try {
            flightService.deleteFlight(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}