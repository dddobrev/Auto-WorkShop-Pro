package com.example.AutoWorkShop.service.impl;

import com.example.AutoWorkShop.domain.entities.RepairDetail;
import com.example.AutoWorkShop.repository.RepairDetailRepository;
import com.example.AutoWorkShop.service.RepairDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RepairDetailServiceImpl implements RepairDetailService {
    private final RepairDetailRepository repairDetailRepository;


    public RepairDetailServiceImpl(RepairDetailRepository repairDetailRepository) {
        this.repairDetailRepository = repairDetailRepository;
    }

    @Override
    public List<RepairDetail> findRepairDetailByRepairId(Long repairId) {
        return repairDetailRepository.findRepairDetailByRepairId(repairId);
    }
}
