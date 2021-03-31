package com.example.AutoWorkShop.service;

import com.example.AutoWorkShop.domain.entities.RepairDetail;
import com.example.AutoWorkShop.domain.service.RepairDetailsAddServiceModel;
import com.example.AutoWorkShop.view.RepairDetailsViewModel;

import java.util.List;

public interface RepairDetailService {

    Long inputRepairDetails(RepairDetailsAddServiceModel repairDetailsAddServiceModel, Long id);

    List<RepairDetailsViewModel> findAllByRepairId(Long id);

    RepairDetailsViewModel findById(Long id);
}
