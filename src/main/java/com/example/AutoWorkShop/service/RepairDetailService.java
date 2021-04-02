package com.example.AutoWorkShop.service;

import com.example.AutoWorkShop.domain.service.RepairDetailsAddServiceModel;
import com.example.AutoWorkShop.view.RepairDetailsViewModel;

public interface RepairDetailService {

    Long inputRepairDetails(RepairDetailsAddServiceModel repairDetailsAddServiceModel);

//    List<RepairDetailsViewModel> findAllByRepairId(Long id);

    RepairDetailsViewModel findById(Long id);
}
