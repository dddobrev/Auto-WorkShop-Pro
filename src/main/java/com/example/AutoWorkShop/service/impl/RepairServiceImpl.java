package com.example.AutoWorkShop.service.impl;

import com.example.AutoWorkShop.domain.entities.RepairEntity;
import com.example.AutoWorkShop.repository.RepairRepository;
import com.example.AutoWorkShop.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RepairServiceImpl implements RepairService {
    private final RepairRepository repairRepository;


    public RepairServiceImpl(RepairRepository repairRepository) {
        this.repairRepository = repairRepository;
    }

    @Override
    public List<RepairEntity> findOrderByCarName(String carName) {
        return this.repairRepository.findRepairByCarBrand(carName);
    }

    @Override
    public List<RepairEntity> findOrderByCarVin(String carVin) {
        return this.repairRepository.findRepairByCarVin(carVin);
    }

    @Override
    public List<RepairEntity> findOrderByCarRegNumber(String carRegNumber) {
        return this.repairRepository.findRepairByCar_RegNumber(carRegNumber);
    }

    @Override
    public List<RepairEntity> findAllByCarVin(String carVin) {
        return this.repairRepository.findAllByCar_Vin(carVin);
    }
}
