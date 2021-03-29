package com.example.AutoWorkShop.repository;

import com.example.AutoWorkShop.domain.entities.ManufacturerEntity;
import com.example.AutoWorkShop.view.ManufactureViewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ManufacturerRepository extends JpaRepository<ManufacturerEntity, Long> {
    Optional<ManufacturerEntity> findManufacturerEntityByManufacturerName(String name);
}
