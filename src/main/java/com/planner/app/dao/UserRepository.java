package com.planner.app.dao;

import com.planner.app.dto.UserDTO;
import com.planner.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    @Query("SELECT new com.planner.app.dto.UserDTO(u.lastName, u.firstName, u.username, u.mail, u.phoneNumber, u.birthday, u.pp) " +
            "FROM User u WHERE u.username = :username")
    UserDTO findByUsername(@Param("username") String username);

}
