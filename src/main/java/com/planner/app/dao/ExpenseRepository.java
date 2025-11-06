package com.planner.app.dao;

import com.planner.app.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
    @Query("SELECT e FROM Expense e WHERE e.voyage.id = :voyageId")
    Optional<Expense> findByVoyageId(@Param("voyageId") Integer voyageId);

}
