package com.example.AutoWorkShop.service;

import com.example.AutoWorkShop.domain.service.ManufacturerAddServiceModel;
import com.example.AutoWorkShop.view.ManufactureViewModel;

import java.util.List;

public interface ManufacturerService {

    ManufactureViewModel findManufacturerByName(String name);
    ManufactureViewModel findManufacturerId(Long id);

    Long inputManufactures(ManufacturerAddServiceModel newManufacture);

    List<ManufactureViewModel> findAll();

    void updateManufactures(ManufacturerAddServiceModel newManufacture);
}
