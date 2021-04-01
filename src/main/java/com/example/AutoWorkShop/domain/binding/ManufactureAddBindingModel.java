package com.example.AutoWorkShop.domain.binding;

public class ManufactureAddBindingModel {
    private Long id;
    private String manufacturerName;

    public ManufactureAddBindingModel() {
    }

    public Long getId() {
        return id;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public ManufactureAddBindingModel setId(Long id) {
        this.id = id;
        return this;
    }

    public ManufactureAddBindingModel setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
        return this;
    }
}
