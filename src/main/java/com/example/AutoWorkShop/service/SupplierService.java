package com.example.AutoWorkShop.service;

import com.example.AutoWorkShop.domain.entities.SupplierEntity;
import com.example.AutoWorkShop.view.SupplierViewModel;

import java.util.List;

public interface SupplierService {
    SupplierEntity findSupplierByName(String supplierName);
    List<SupplierViewModel> findAll();

    void seedSuppliers();
}
