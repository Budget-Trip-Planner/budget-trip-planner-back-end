package com.planner.app.service;

import com.planner.app.dao.VoyageRepository;
import com.planner.app.entity.Voyage;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List; 

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class VoyageService {

    private final VoyageRepository voyageRepository;

    @Transactional
    public Voyage getVoyageById(Integer id) {
        return voyageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Voyage not found with id " + id));
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



}
