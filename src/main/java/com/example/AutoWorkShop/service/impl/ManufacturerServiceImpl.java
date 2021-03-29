package com.example.AutoWorkShop.service.impl;

import com.example.AutoWorkShop.domain.entities.ManufacturerEntity;
import com.example.AutoWorkShop.repository.ManufacturerRepository;
import com.example.AutoWorkShop.service.ManufacturerService;
import com.example.AutoWorkShop.view.ManufactureViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
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
        // Todo findManufacturerByName
        return manufacturerRepository
                .findManufacturerEntityByManufacturerName(name)
                .map(man -> modelMapper.map(man, ManufactureViewModel.class))
                .orElse(null);
    }

    @Override
    public void inputManufactures(ManufacturerEntity manufacturerEntity) {

        Optional<ManufacturerEntity> manufacturerEntityByManufacturerName =
                manufacturerRepository
                        .findManufacturerEntityByManufacturerName(manufacturerEntity.getManufacturerName());
        if (!manufacturerEntityByManufacturerName.isPresent()) {
            ManufacturerEntity manEntity = new ManufacturerEntity();
            manEntity.setManufacturerName(manufacturerEntity.getManufacturerName().toUpperCase());
            manufacturerRepository.save(manEntity);
        }
    }

    @Override
    public List<ManufactureViewModel> findAll() {
        return manufacturerRepository
                .findAll()
                .stream()
                .map(man -> modelMapper.map(man, ManufactureViewModel.class))
                .collect(Collectors.toList());
    }
}
