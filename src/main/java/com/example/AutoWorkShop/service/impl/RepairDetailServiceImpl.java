package com.example.AutoWorkShop.service.impl;

import com.example.AutoWorkShop.domain.entities.RepairDetail;
import com.example.AutoWorkShop.domain.entities.RepairEntity;
import com.example.AutoWorkShop.domain.service.RepairDetailsAddServiceModel;
import com.example.AutoWorkShop.repository.RepairDetailRepository;
import com.example.AutoWorkShop.repository.RepairRepository;
import com.example.AutoWorkShop.service.RepairDetailService;
import com.example.AutoWorkShop.view.RepairDetailsViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RepairDetailServiceImpl implements RepairDetailService {
    private final RepairDetailRepository repairDetailRepository;
    private final ModelMapper modelMapper;
    private final RepairRepository repairRepository;

    public RepairDetailServiceImpl(RepairDetailRepository repairDetailRepository,
                                   ModelMapper modelMapper,
                                   RepairRepository repairRepository) {
        this.repairDetailRepository = repairDetailRepository;
        this.modelMapper = modelMapper;
        this.repairRepository = repairRepository;
    }

    @Override
    public Long inputRepairDetails(RepairDetailsAddServiceModel repairDetailsAddServiceModel, Long id) {
        RepairDetail newRepairDetail = modelMapper
                .map(repairDetailsAddServiceModel, RepairDetail.class);
        RepairEntity repairEntity = repairRepository.findById(id).orElse(null);
        newRepairDetail
                .setRepair(repairEntity)
                .setAutoParts(repairDetailsAddServiceModel.getAutoParts())
                .setPrice(repairDetailsAddServiceModel.getPrice())
                .setRepairDescription(repairDetailsAddServiceModel.getRepairDescription())
                .setRemarks(repairDetailsAddServiceModel.getRemarks());

        repairDetailRepository.save(newRepairDetail);

        return newRepairDetail.getId();
    }

    @Override
    public List<RepairDetailsViewModel> findAllByRepairId(Long id) {
        //todo implement

        return null;
    }

    @Override
    public RepairDetailsViewModel findById(Long id) {
        return repairDetailRepository
                .findById(id)
                .map(rd -> modelMapper.map(rd, RepairDetailsViewModel.class))
                .orElse(null);
    }
}
