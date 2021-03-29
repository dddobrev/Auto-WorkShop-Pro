package com.example.AutoWorkShop.repository;


import com.example.AutoWorkShop.domain.entities.AutoPartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutoPartRepository extends JpaRepository<AutoPartEntity, Long> {
    Optional<AutoPartEntity> findByPartNumber(String number);
    List<AutoPartEntity> findByPartOeNumber(String oeNumber);
    List<AutoPartEntity> findAutoPartByName(String name);
}
