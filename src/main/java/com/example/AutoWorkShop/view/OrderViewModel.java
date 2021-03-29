package com.example.AutoWorkShop.view;

import com.example.AutoWorkShop.domain.entities.CarEntity;
import com.example.AutoWorkShop.domain.entities.UserEntity;
import com.example.AutoWorkShop.domain.entities.enums.ClassificationEnum;
import com.example.AutoWorkShop.domain.entities.enums.ProgressEnum;

import java.time.LocalDate;

public class OrderViewModel {
    private Long id;
    private LocalDate dataOrder;
    private CarEntity car;
    private ClassificationEnum classificationEnum;
    private String comment;
    private LocalDate dataIn;
    private LocalDate dataOut;
    private UserEntity userEntity;
    private ProgressEnum progressEnum;

    public OrderViewModel() {
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDataOrder() {
        return dataOrder;
    }

    public CarEntity getCar() {
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

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public ProgressEnum getProgressEnum() {
        return progressEnum;
    }

    public OrderViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public OrderViewModel setDataOrder(LocalDate dataOrder) {
        this.dataOrder = dataOrder;
        return this;
    }

    public OrderViewModel setCar(CarEntity car) {
        this.car = car;
        return this;
    }

    public OrderViewModel setClassificationEnum(ClassificationEnum classificationEnum) {
        this.classificationEnum = classificationEnum;
        return this;
    }

    public OrderViewModel setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public OrderViewModel setDataIn(LocalDate dataIn) {
        this.dataIn = dataIn;
        return this;
    }

    public OrderViewModel setDataOut(LocalDate dataOut) {
        this.dataOut = dataOut;
        return this;
    }

    public OrderViewModel setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
        return this;
    }

    public OrderViewModel setProgressEnum(ProgressEnum progressEnum) {
        this.progressEnum = progressEnum;
        return this;
    }
}
