package com.planner.app.dao;

import com.planner.app.entity.Locations;
import com.planner.app.entity.Voyage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocationsRepository extends JpaRepository<Locations, Integer> {

    Optional<Locations> findFirstByCityAndCountry(String city, String country);
}
