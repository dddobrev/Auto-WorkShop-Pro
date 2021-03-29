package com.example.AutoWorkShop.domain.service;

import com.example.AutoWorkShop.domain.entities.CarEntity;
import com.example.AutoWorkShop.domain.entities.UserEntity;
import com.example.AutoWorkShop.domain.entities.enums.ClassificationEnum;

import java.time.LocalDate;

public class RepairAddServiceModel {
    private Long id;
    private CarEntity car;
    private Integer oldKm;
    private Integer newKm;
    private LocalDate dataInGarage;
    private LocalDate dataOutGarage;
    private ClassificationEnum classificationEnum;
    private String userEntity;

    public RepairAddServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public CarEntity getCar() {
        return car;
    }

    public Integer getOldKm() {
        return oldKm;
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

    public String getUserEntity() {
        return userEntity;
    }

    public RepairAddServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public RepairAddServiceModel setCar(CarEntity car) {
        this.car = car;
        return this;
    }

    public RepairAddServiceModel setOldKm(Integer oldKm) {
        this.oldKm = oldKm;
        return this;
    }

    public RepairAddServiceModel setNewKm(Integer newKm) {
        this.newKm = newKm;
        return this;
    }

    public RepairAddServiceModel setDataInGarage(LocalDate dataInGarage) {
        this.dataInGarage = dataInGarage;
        return this;
    }

    public RepairAddServiceModel setDataOutGarage(LocalDate dataOutGarage) {
        this.dataOutGarage = dataOutGarage;
        return this;
    }

    public RepairAddServiceModel setClassificationEnum(ClassificationEnum classificationEnum) {
        this.classificationEnum = classificationEnum;
        return this;
    }

    public RepairAddServiceModel setUserEntity(String userEntity) {
        this.userEntity = userEntity;
        return this;
    }
}
