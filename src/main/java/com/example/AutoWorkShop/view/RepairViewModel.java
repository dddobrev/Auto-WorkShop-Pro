package com.example.AutoWorkShop.view;

import com.example.AutoWorkShop.domain.entities.CarEntity;
import com.example.AutoWorkShop.domain.entities.enums.ClassificationEnum;

import java.time.LocalDate;

public class RepairViewModel {
    private Long id;
    private CarEntity car;
    private Integer newKm;
    private LocalDate dataInGarage;
    private LocalDate dataOutGarage;

    public Long getId() {
        return id;
    }

    private ClassificationEnum classificationEnum;

    public RepairViewModel() {
    }


    public CarEntity getCar() {
        return car;
    }

    public Integer getNewKm() {
        return newKm;
    }

    public LocalDate getDataInGarage() {
        return dataInGarage;
    }

    public LocalDate getDataOutGarage() {
        return dataOutGarage;
    }

    public ClassificationEnum getClassificationEnum() {
        return classificationEnum;
    }

    public RepairViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public RepairViewModel setCar(CarEntity car) {
        this.car = car;
        return this;
    }

    public RepairViewModel setNewKm(Integer newKm) {
        this.newKm = newKm;
        return this;
    }

    public RepairViewModel setDataInGarage(LocalDate dataInGarage) {
        this.dataInGarage = dataInGarage;
        return this;
    }

    public RepairViewModel setDataOutGarage(LocalDate dataOutGarage) {
        this.dataOutGarage = dataOutGarage;
        return this;
    }

    public RepairViewModel setClassificationEnum(ClassificationEnum classificationEnum) {
        this.classificationEnum = classificationEnum;
        return this;
    }
}
