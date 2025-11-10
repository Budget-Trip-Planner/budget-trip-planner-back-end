package com.planner.app.controller;

import com.planner.app.dto.UserDTO;
import com.planner.app.entity.Voyage;
import com.planner.app.service.UserService;
import com.planner.app.service.VoyageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final VoyageService voyageService;

    // Nouvelle route : recup les voyages dun utilisateur
    @GetMapping("/{id}/proposals")
    public ResponseEntity<List<Voyage>> getUserProposals(@PathVariable Integer id) {
        List<Voyage> voyages = voyageService.getVoyagesByUserId(id);
        return ResponseEntity.ok(voyages);
    }
}
