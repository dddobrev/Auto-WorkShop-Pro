package com.example.AutoWorkShop.service;

import com.example.AutoWorkShop.domain.entities.RepairDetail;

import java.util.List;

public interface RepairDetailService {
    List<RepairDetail> findRepairDetailByRepairId(Long repairId);
}
