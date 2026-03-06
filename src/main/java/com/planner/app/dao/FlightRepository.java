package com.planner.app.dao;

import com.planner.app.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

    List<Flight> findByVoyageId(Integer voyageId);

    boolean existsByVoyageIdAndDirection(Integer voyageId, String direction);
}