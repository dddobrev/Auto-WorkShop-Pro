package com.example.AutoWorkShop.service.impl;

import com.example.AutoWorkShop.domain.entities.AutoPartEntity;
import com.example.AutoWorkShop.domain.service.AutoPartServiceModel;
import com.example.AutoWorkShop.repository.AutoPartRepository;
import com.example.AutoWorkShop.service.AutoPartService;
import com.example.AutoWorkShop.view.AutoPartsViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class AutoPartServiceImpl implements AutoPartService {
    private final AutoPartRepository autoPartRepository;
    private final ModelMapper modelMapper;

    public AutoPartServiceImpl(AutoPartRepository autoPartRepository, ModelMapper modelMapper) {
        this.autoPartRepository = autoPartRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public AutoPartsViewModel findAutoPartByNumber(String number) {
        return this.autoPartRepository
                .findByPartNumber(number)
                .map(ap -> modelMapper.map(ap, AutoPartsViewModel.class))
                .orElse(null);
    }

    @Override
    public List<AutoPartsViewModel> findAutoPartByOeNumber(String oeNumber) {
        return autoPartRepository
                .findByPartOeNumber(oeNumber)
                .stream()
                .map(ap -> modelMapper.map(ap, AutoPartsViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<AutoPartsViewModel> findAutoPartsByName(String name) {
        return this.autoPartRepository
                .findAutoPartByName(name)
                .stream()
                .map(ap -> modelMapper.map(ap, AutoPartsViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<AutoPartsViewModel> findAllAutoParts() {
        return this.autoPartRepository
                .findAll()
                .stream()
                .map(ap-> modelMapper.map(ap, AutoPartsViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public boolean partExist(String partNumber) {
        return autoPartRepository.findByPartNumber(partNumber).isEmpty();
    }

    @Override
    public void inputParts(AutoPartServiceModel autoPartServiceModel) {
        AutoPartEntity autoPartEntity = modelMapper
                .map(autoPartServiceModel, AutoPartEntity.class);

        autoPartEntity.setSupplier(autoPartServiceModel.getSupplier())
                .setManufacturer(autoPartServiceModel.getManufacturer())
                .setPartNumber(autoPartServiceModel.getPartNumber())
                .setPartOeNumber(autoPartServiceModel.getPartOeNumber())
                .setPriceIn(autoPartServiceModel.getPriceIn())
                .setPriceOut(autoPartServiceModel.getPriceOut())
                .setPiece(autoPartServiceModel.getPiece());
        autoPartRepository.save(autoPartEntity);
    }

    @Override
    public AutoPartsViewModel findAutoPartById(Long id) {
        return this.autoPartRepository.findById(id)
                .map(ap-> modelMapper.map(ap, AutoPartsViewModel.class))
                .orElse(null);
    }

    @Override
    public void updateClient(AutoPartServiceModel editParts) {
        AutoPartEntity autoPartEntity = autoPartRepository
                .findById(editParts.getId())
                .orElse(null);
        if (autoPartEntity !=null){
            autoPartEntity.setSupplier(editParts.getSupplier())
                    .setManufacturer(editParts.getManufacturer())
                    .setPartNumber(editParts.getPartNumber())
                    .setPartOeNumber(editParts.getPartOeNumber())
                    .setPriceIn(editParts.getPriceIn())
                    .setPriceOut(editParts.getPriceOut())
                    .setPiece(editParts.getPiece());
            autoPartRepository.save(autoPartEntity);
        }
    }
}
