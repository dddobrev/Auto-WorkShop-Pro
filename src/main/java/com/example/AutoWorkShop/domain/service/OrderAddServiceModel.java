package com.example.AutoWorkShop.domain.service;

import com.example.AutoWorkShop.domain.entities.CarEntity;
import com.example.AutoWorkShop.domain.entities.UserEntity;
import com.example.AutoWorkShop.domain.entities.enums.ClassificationEnum;
import com.example.AutoWorkShop.domain.entities.enums.ProgressEnum;

import java.time.LocalDate;

public class OrderAddServiceModel {
    private LocalDate dataOrder;
    private String car;
    private ClassificationEnum classificationEnum;
    private String comment;
    private LocalDate dataIn;
    private LocalDate dataOut;
    private String userEntity;
    private ProgressEnum progressEnum = ProgressEnum.OPEN;

    public OrderAddServiceModel() {
    }

    public LocalDate getDataOrder() {
        return dataOrder;
    }

    public String getCar() {
        return car;
    }

    public ClassificationEnum getClassificationEnum() {
        return classificationEnum;
    }

    public String getComment() {
        return comment;
    }

    public LocalDate getDataIn() {
        return dataIn;
    }

    public LocalDate getDataOut() {
        return dataOut;
    }

    public String getUserEntity() {
        return userEntity;
    }

    public ProgressEnum getProgressEnum() {
        return progressEnum;
    }

    public OrderAddServiceModel setDataOrder(LocalDate dataOrder) {
        this.dataOrder = dataOrder;
        return this;
    }

    public OrderAddServiceModel setCar(String car) {
        this.car = car;
        return this;
    }

    public OrderAddServiceModel setClassificationEnum(ClassificationEnum classificationEnum) {
        this.classificationEnum = classificationEnum;
        return this;
    }

    public OrderAddServiceModel setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public OrderAddServiceModel setDataIn(LocalDate dataIn) {
        this.dataIn = dataIn;
        return this;
    }

    public OrderAddServiceModel setDataOut(LocalDate dataOut) {
        this.dataOut = dataOut;
        return this;
    }

    public OrderAddServiceModel setUserEntity(String userEntity) {
        this.userEntity = userEntity;
        return this;
    }

    public OrderAddServiceModel setProgressEnum(ProgressEnum progressEnum) {
        this.progressEnum = progressEnum;
        return this;
    }
}
