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

    // PROFIL : GET
    @GetMapping("/{id}/profile")
    public ResponseEntity<UserDTO> getUserProfile(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserProfile(id));
    }

    // PROFIL : UPDATE
    @PutMapping("/{id}/profile")
    public ResponseEntity<UserDTO> updateUserProfile(
            @PathVariable Long id,
            @RequestBody UserDTO userDto
    ) {
        return ResponseEntity.ok(userService.updateUserProfile(id, userDto));
    }

    // Nouvelle route : recup les voyages dun utilisateur
    @GetMapping("/{id}/proposals")
    public ResponseEntity<List<Voyage>> getUserProposals(@PathVariable Integer id) {
        return ResponseEntity.ok(voyageService.getVoyagesByUserId(id));
    }
}
