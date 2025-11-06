package com.planner.app.dao;

import com.planner.app.entity.Itinerary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItineraryRepository extends JpaRepository<Itinerary, Integer> {
    @Query("SELECT i FROM Itinerary i WHERE i.voyage.id = :voyageId ORDER BY i.dayNumber ASC")
    Optional<List<Itinerary>> findByVoyageIdOrderByDayNumberAsc(@Param("voyageId") Integer voyageId);

}
