package com.example.AutoWorkShop.service.impl;

import com.example.AutoWorkShop.domain.entities.ManufacturerEntity;
import com.example.AutoWorkShop.domain.service.ManufacturerAddServiceModel;
import com.example.AutoWorkShop.repository.ManufacturerRepository;
import com.example.AutoWorkShop.service.ManufacturerService;
import com.example.AutoWorkShop.view.ManufactureViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ManufacturerServiceImpl implements ManufacturerService {
    private final ManufacturerRepository manufacturerRepository;
    private final ModelMapper modelMapper;

    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository,
                                   ModelMapper modelMapper) {
        this.manufacturerRepository = manufacturerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ManufactureViewModel findManufacturerByName(String name) {
        return manufacturerRepository
                .findManufacturerEntityByManufacturerName(name)
                .map(man -> modelMapper.map(man, ManufactureViewModel.class))
                .orElse(null);
    }

    @Override
    public ManufactureViewModel findManufacturerId(Long id) {
        return manufacturerRepository.findById(id)
                .map(manufacturerEntity -> modelMapper.map(manufacturerEntity, ManufactureViewModel.class))
                .orElse(null);
    }

    @Override
    public Long inputManufactures(ManufacturerAddServiceModel newManufacture) {

        ManufacturerEntity manufacturerEntity =
                modelMapper.map(newManufacture, ManufacturerEntity.class);
        manufacturerEntity.setManufacturerName(newManufacture.getManufacturerName());
        manufacturerRepository.save(manufacturerEntity);
        return manufacturerEntity.getId();
    }

    @Override
    public List<ManufactureViewModel> findAll() {
        return manufacturerRepository
                .findAll()
                .stream()
                .map(man -> modelMapper.map(man, ManufactureViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void updateManufactures(ManufacturerAddServiceModel newManufacture) {
        ManufacturerEntity manufacturerEntity = manufacturerRepository
                .findById(newManufacture.getId()).orElse(null);
        if (manufacturerEntity!=null){
            manufacturerEntity.setManufacturerName(newManufacture.getManufacturerName());
            manufacturerRepository.save(manufacturerEntity);
        }
    }
}
