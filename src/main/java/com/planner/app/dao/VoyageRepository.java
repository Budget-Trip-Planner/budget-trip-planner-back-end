package com.planner.app.dao;

import com.planner.app.entity.Voyage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface VoyageRepository extends JpaRepository<Voyage, Integer> {

    @Query(value = "SELECT * FROM voyages WHERE object_type = 'users' AND object_id = :userId", nativeQuery = true)
    List<Voyage> findByUserId(@Param("userId") Integer userId);

    @Query("SELECT v FROM Voyage v WHERE v.budgetTotal <= :budget AND v.destination.city = :destination")
    List<Voyage> findByBudgetAndDestination(
            @Param("budget") BigDecimal budget,
            @Param("destination") String destination
    );

    // Find voyage proposals matching budget, duration, and departure city
    @Query("SELECT v FROM Voyage v " +
            "WHERE v.budgetTotal <= :budget " +
            "AND v.durationDays <= :duration " +
            "AND (:departureCity IS NULL OR v.departure.city = :departureCity) " +
            "ORDER BY v.budgetTotal ASC")
    List<Voyage> findProposals(
            @Param("budget") BigDecimal budget,
            @Param("duration") Integer duration,
            @Param("departureCity") String departureCity
    );

    // Find proposals by destination city
    @Query("SELECT v FROM Voyage v " +
            "WHERE v.budgetTotal <= :budget " +
            "AND v.destination.city = :destinationCity " +
            "ORDER BY v.budgetTotal ASC")
    List<Voyage> findByBudgetAndDestinationCity(
            @Param("budget") BigDecimal budget,
            @Param("destinationCity") String destinationCity
    );

    @Query("SELECT v FROM Voyage v")
    List<Voyage> findAll();
}