package com.example.AutoWorkShop.repository;

import com.example.AutoWorkShop.domain.entities.CarEntity;
import com.example.AutoWorkShop.view.CarViewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {

    Optional<CarEntity> findCarByRegNumber(String regNumber);

    List<CarEntity> findCarByVin(String vin);

    List<CarEntity> findByBrand(String brand);

    List<CarEntity> findCarEntityByBrandAndModel(String brand, String model);

    List<CarEntity> findCarEntitiesByEngine(String engine);

    List<CarEntity> findCarEntitiesByCoupeModelContains(String coupeModel);

    List<CarEntity> findCarEntitiesByBrandContaining(String brand);

    List<CarEntity> findAll();

    Optional<CarEntity> findCarById(Long id);
}
