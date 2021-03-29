package com.example.AutoWorkShop.service;

import com.example.AutoWorkShop.domain.entities.RepairEntity;
import com.example.AutoWorkShop.domain.service.RepairAddServiceModel;
import com.example.AutoWorkShop.view.RepairViewModel;

import java.util.List;

public interface RepairService {
    List<RepairEntity> findOrderByCarName(String carName);
    List<RepairEntity> findOrderByCarVin(String carVin);
    List<RepairEntity> findOrderByCarRegNumber(String carRegNumber);
    List<RepairEntity> findAllByCarVin(String carVin);

    Long inputRepair(RepairAddServiceModel newRepair);

    RepairViewModel findById(Long id);
}
