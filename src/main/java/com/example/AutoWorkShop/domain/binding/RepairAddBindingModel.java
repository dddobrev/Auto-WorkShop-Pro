package com.example.AutoWorkShop.domain.binding;

import com.example.AutoWorkShop.domain.entities.CarEntity;
import com.example.AutoWorkShop.domain.entities.enums.ClassificationEnum;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;

public class RepairAddBindingModel {
    private Long id;
    private CarEntity car;
    private Integer oldKm;
    private Integer newKm;
    private LocalDate dataInGarage;
    private LocalDate dataOutGarage;
    private ClassificationEnum classificationEnum;

    public RepairAddBindingModel() {
    }

    public Long getId() {
        return id;
    }

    @NotNull
    public CarEntity getCar() {
        return car;
    }

    public Integer getOldKm() {
        return oldKm;
    }

    @NotNull
    @PositiveOrZero
    public Integer getNewKm() {
        return newKm;
    }


    public LocalDate getDataInGarage() {
        return dataInGarage;
    }

    public LocalDate getDataOutGarage() {
        return dataOutGarage;
    }

    @NotNull
    public ClassificationEnum getClassificationEnum() {
        return classificationEnum;
    }

    public RepairAddBindingModel setId(Long id) {
        this.id = id;
        return this;
    }

    public RepairAddBindingModel setCar(CarEntity car) {
        this.car = car;
        return this;
    }

    public RepairAddBindingModel setOldKm(Integer oldKm) {
        this.oldKm = oldKm;
        return this;
    }

    public RepairAddBindingModel setNewKm(Integer newKm) {
        this.newKm = newKm;
        return this;
    }

    public RepairAddBindingModel setDataInGarage(LocalDate dataInGarage) {
        this.dataInGarage = dataInGarage;
        return this;
    }

    public RepairAddBindingModel setDataOutGarage(LocalDate dataOutGarage) {
        this.dataOutGarage = dataOutGarage;
        return this;
    }

    public RepairAddBindingModel setClassificationEnum(ClassificationEnum classificationEnum) {
        this.classificationEnum = classificationEnum;
        return this;
    }
}
