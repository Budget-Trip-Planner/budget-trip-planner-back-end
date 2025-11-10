package com.planner.app.dao;

import com.planner.app.entity.Voyage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoyageRepository extends JpaRepository<Voyage, Integer> {

    @Query(
        value = "SELECT * FROM voyages WHERE object_type = 'users' AND object_id = :userId",
        nativeQuery = true
    )
    List<Voyage> findByUserId(@Param("userId") Integer userId);

}
