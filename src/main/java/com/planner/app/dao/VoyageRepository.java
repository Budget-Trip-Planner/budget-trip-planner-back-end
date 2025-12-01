package com.planner.app.dao;

import com.planner.app.entity.Voyage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface VoyageRepository extends JpaRepository<Voyage, Integer> {

    @Query(
        value = "SELECT * FROM voyages WHERE object_type = 'users' AND object_id = :userId",
        nativeQuery = true
    )
    List<Voyage> findByUserId(@Param("userId") Integer userId);

    @Query(value = "SELECT v FROM Voyage v WHERE v.budgetTotal <= :budget AND v.destination = :destination")
    List<Voyage> findByBudgetAndDestination(@Param("budget") BigDecimal budget, @Param("destination") String destination);

    @Query("SELECT v FROM Voyage v")
    List<Voyage> findAll();

}
