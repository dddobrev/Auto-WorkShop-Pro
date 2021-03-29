package com.example.AutoWorkShop.view;

import com.example.AutoWorkShop.domain.entities.AutoPartEntity;

import java.util.HashSet;
import java.util.Set;

public class ManufactureViewModel {
    private Long id;
    private String manufacturerName;
//    private Set<AutoPartEntity> autoParts = new HashSet<>();

    public ManufactureViewModel() {
    }

    public Long getId() {
        return id;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

//    public Set<AutoPartEntity> getAutoParts() {
//        return autoParts;
//    }

    public ManufactureViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public ManufactureViewModel setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
        return this;
    }

//    public ManufactureViewModel setAutoParts(Set<AutoPartEntity> autoParts) {
//        this.autoParts = autoParts;
//        return this;
//    }
}
