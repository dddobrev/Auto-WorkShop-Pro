package com.example.AutoWorkShop.domain.service;

public class ManufacturerAddServiceModel {
    private Long id;
    private String manufacturerName;

    public ManufacturerAddServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public ManufacturerAddServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public ManufacturerAddServiceModel setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
        return this;
    }
}
