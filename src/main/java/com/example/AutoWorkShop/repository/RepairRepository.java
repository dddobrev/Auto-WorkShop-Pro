package com.example.AutoWorkShop.repository;


import com.example.AutoWorkShop.domain.entities.RepairEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepairRepository extends JpaRepository<RepairEntity, Long> {
    List<RepairEntity> findRepairByCarBrand(String carBrand);
    List<RepairEntity> findRepairByCarVin(String carVin);
    List<RepairEntity> findRepairByCar_RegNumber(String carRegNumber);
    List<RepairEntity> findAllByCar_Vin(String carVin);
}
