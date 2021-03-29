package com.example.AutoWorkShop.service;

import com.example.AutoWorkShop.domain.entities.ManufacturerEntity;
import com.example.AutoWorkShop.view.ManufactureViewModel;

import java.util.List;
import java.util.Optional;

public interface ManufacturerService {
    ManufactureViewModel findManufacturerByName(String name);

    void inputManufactures(ManufacturerEntity manufacturerEntity);

    List<ManufactureViewModel> findAll();
}
