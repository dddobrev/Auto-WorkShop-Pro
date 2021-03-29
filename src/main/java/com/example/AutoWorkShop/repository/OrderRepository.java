package com.example.AutoWorkShop.repository;

import com.example.AutoWorkShop.domain.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    List<OrderEntity> findOrderByCarBrand (String carBrand);
    List<OrderEntity> findOrderByCarVin(String carVin);
    List<OrderEntity> findOrderByCarRegNumber(String carRegNumber);
    List<OrderEntity> findAllByUserEntity_Username(String username);
}
