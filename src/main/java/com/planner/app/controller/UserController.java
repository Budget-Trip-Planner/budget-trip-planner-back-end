package com.planner.app.controller;

import com.planner.app.dto.UserResponseDTO;
import com.planner.app.dto.VoyageDTO;
import com.planner.app.entity.Voyage;
import com.planner.app.mapper.VoyageMapper;
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
    private final VoyageMapper voyageMapper;

    // PROFIL : GET
    @GetMapping("/{id}/profile")
    public ResponseEntity<UserResponseDTO> getUserProfile(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserProfile(id));
    }

    // PROFIL : UPDATE
    @PutMapping("/{id}/profile")
    public ResponseEntity<UserResponseDTO> updateUserProfile(
            @PathVariable Long id,
            @RequestBody UserResponseDTO userDto
    ) {
        return ResponseEntity.ok(userService.updateUserProfile(id, userDto));
    }

    // Récupérer les voyages d'un utilisateur
    @GetMapping("/{id}/proposals")
    public ResponseEntity<List<VoyageDTO>> getUserProposals(@PathVariable Integer id) {
        List<VoyageDTO> voyages = voyageService.getVoyagesByUserId(id).stream()
                .map(voyageMapper::toDTO)
                .toList();
        return ResponseEntity.ok(voyages);
    }
}