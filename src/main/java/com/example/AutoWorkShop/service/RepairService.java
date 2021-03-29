package com.example.AutoWorkShop.service;

import com.example.AutoWorkShop.domain.entities.RepairEntity;

import java.util.List;

public interface RepairService {
    List<RepairEntity> findOrderByCarName(String carName);
    List<RepairEntity> findOrderByCarVin(String carVin);
    List<RepairEntity> findOrderByCarRegNumber(String carRegNumber);
    List<RepairEntity> findAllByCarVin(String carVin);
}
