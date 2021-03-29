package com.example.AutoWorkShop.repository;


import com.example.AutoWorkShop.domain.entities.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SupplierRepository extends JpaRepository<SupplierEntity, Long> {
   Optional<SupplierEntity> findSupplierBySupplierNameContains(String supplierName);
   List<SupplierEntity> findAll();
}
