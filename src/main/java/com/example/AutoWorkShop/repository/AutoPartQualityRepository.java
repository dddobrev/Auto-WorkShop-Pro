package com.example.AutoWorkShop.repository;

import com.example.AutoWorkShop.domain.entities.AutoPartQualityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoPartQualityRepository extends JpaRepository<AutoPartQualityEntity, Long> {
}
