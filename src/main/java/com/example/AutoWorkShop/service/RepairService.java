package com.example.AutoWorkShop.service;

import com.example.AutoWorkShop.domain.entities.RepairEntity;
import com.example.AutoWorkShop.domain.service.RepairAddServiceModel;
import com.example.AutoWorkShop.view.RepairViewModel;

import java.util.List;

public interface RepairService {
    List<RepairViewModel> findOrderByCarName(String carName);

    List<RepairViewModel> findOrderByCarVin(String carVin);

    List<RepairViewModel> findOrderByCarRegNumber(String carRegNumber);

    Long inputRepair(RepairAddServiceModel newRepair);

    RepairViewModel findById(Long id);

    List<RepairViewModel> findRepairByCarId(Long id);
}
