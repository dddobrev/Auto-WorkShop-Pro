package com.example.AutoWorkShop.repository;

import com.example.AutoWorkShop.domain.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);

    @Query("SELECT u.username FROM UserEntity AS u " +
            "ORDER BY u.username ")
    List<String> getAllUsernames();

}
