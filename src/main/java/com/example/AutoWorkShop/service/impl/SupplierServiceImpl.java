package com.example.AutoWorkShop.service.impl;

import com.example.AutoWorkShop.domain.entities.SupplierEntity;
import com.example.AutoWorkShop.repository.SupplierRepository;
import com.example.AutoWorkShop.service.SupplierService;
import com.example.AutoWorkShop.view.SupplierViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;
    private final ModelMapper modelMapper;

    public SupplierServiceImpl(SupplierRepository supplierRepository, ModelMapper modelMapper) {
        this.supplierRepository = supplierRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedSuppliers() {
        if (supplierRepository.count() == 0) {
            SupplierEntity supplier1 = new SupplierEntity();
            SupplierEntity supplier2 = new SupplierEntity();
            SupplierEntity supplier3 = new SupplierEntity();
            supplier1.setSupplierName("EURO 07")
                    .setSupplierContactPerson("Nikolai")
                    .setSupplierTelephone("0888123456");
            supplier2.setSupplierName("KOSER")
                    .setSupplierContactPerson("Tcanko")
                    .setSupplierTelephone("0888789456");
            supplier3.setSupplierName("AUTO PLUS")
                    .setSupplierContactPerson("Ivan")
                    .setSupplierTelephone("0888963888");
            supplierRepository.saveAll(List.of(supplier1, supplier2, supplier3));
        }
    }

    @Override
    public SupplierEntity findSupplierByName(String supplierName) {
        return this.supplierRepository
                .findSupplierBySupplierNameContains(supplierName)
                .orElse(null);
    }

    @Override
    public List<SupplierViewModel> findAll() {
        return supplierRepository
                .findAll()
                .stream()
                .map(sup -> modelMapper.map(sup, SupplierViewModel.class))
                .collect(Collectors.toList());
    }


}
