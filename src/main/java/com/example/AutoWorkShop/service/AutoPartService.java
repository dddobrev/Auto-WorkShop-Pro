package com.example.AutoWorkShop.service;

import com.example.AutoWorkShop.domain.service.AutoPartServiceModel;
import com.example.AutoWorkShop.view.AutoPartsViewModel;

import java.util.List;
import java.util.Optional;

public interface AutoPartService {
    AutoPartsViewModel findAutoPartByNumber(String number);

    List<AutoPartsViewModel> findAutoPartByOeNumber(String oeNumber);

    List<AutoPartsViewModel> findAutoPartsByName(String name);

    boolean partExist(String partNumber);

    void inputParts(AutoPartServiceModel autoPartServiceModel);

    AutoPartsViewModel findAutoPartById(Long id);

    void updateClient(AutoPartServiceModel editParts);
}
