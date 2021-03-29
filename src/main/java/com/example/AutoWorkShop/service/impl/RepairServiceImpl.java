package com.example.AutoWorkShop.service.impl;

import com.example.AutoWorkShop.domain.entities.CarEntity;
import com.example.AutoWorkShop.domain.entities.RepairEntity;
import com.example.AutoWorkShop.domain.entities.UserEntity;
import com.example.AutoWorkShop.domain.service.RepairAddServiceModel;
import com.example.AutoWorkShop.repository.RepairRepository;
import com.example.AutoWorkShop.repository.UserRepository;
import com.example.AutoWorkShop.service.CarService;
import com.example.AutoWorkShop.service.RepairService;
import com.example.AutoWorkShop.view.RepairViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class RepairServiceImpl implements RepairService {
    private final RepairRepository repairRepository;
    private final UserRepository userRepository;
    private final CarService carService;
    private final ModelMapper modelMapper;


    public RepairServiceImpl(RepairRepository repairRepository, UserRepository userRepository, CarService carService, ModelMapper modelMapper) {
        this.repairRepository = repairRepository;
        this.userRepository = userRepository;
        this.carService = carService;
        this.modelMapper = modelMapper;
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

    @Override
    public Long inputRepair(RepairAddServiceModel newRepair) {
        RepairEntity newRepairEntity = modelMapper
                .map(newRepair, RepairEntity.class);
        LocalDate now = LocalDate.now();
        UserEntity username = userRepository.
                findByUsername(newRepair.getUserEntity()).orElse(null);

        CarEntity carEntity = carService.findCarEntityById(newRepair.getCar().getId());
        newRepairEntity.setUserEntity(username)
                .setCar(carEntity)
                .setClassificationEnum(newRepair.getClassificationEnum())
                .setDataInGarage(now)
                .setNewKm(newRepair.getNewKm());
        repairRepository.save(newRepairEntity);

        return newRepairEntity.getId();
    }

    @Override
    public RepairViewModel findById(Long id) {
        return repairRepository.findById(id)
                .map(rep-> modelMapper.map(rep, RepairViewModel.class))
                .orElse(null);
    }
}
