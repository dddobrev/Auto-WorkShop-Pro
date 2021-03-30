package com.example.AutoWorkShop.domain.binding;

import com.example.AutoWorkShop.domain.entities.CarEntity;
import com.example.AutoWorkShop.domain.entities.UserEntity;
import com.example.AutoWorkShop.domain.entities.enums.ClassificationEnum;
import com.example.AutoWorkShop.domain.entities.enums.ProgressEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class OrderAddBindingModel {

    private LocalDate dataOrder;
    private CarEntity car;
    private ClassificationEnum classificationEnum;
    private String comment;
    private LocalDate dataIn;
    private LocalDate dataOut;
    private String userEntity;
    private ProgressEnum progressEnum = ProgressEnum.OPEN;

    public OrderAddBindingModel() {
    }

    public LocalDate getDataOrder() {
        return dataOrder;
    }

    @NotNull
    public CarEntity getCar() {
        return car;
    }

    @NotNull
    public ClassificationEnum getClassificationEnum() {
        return classificationEnum;
    }

    public String getComment() {
        return comment;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "The date cannot be in the past")
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

    public OrderAddBindingModel setDataOrder(LocalDate dataOrder) {
        this.dataOrder = dataOrder;
        return this;
    }

    public OrderAddBindingModel setCar(CarEntity car) {
        this.car = car;
        return this;
    }

    public OrderAddBindingModel setClassificationEnum(ClassificationEnum classificationEnum) {
        this.classificationEnum = classificationEnum;
        return this;
    }

    public OrderAddBindingModel setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public OrderAddBindingModel setDataIn(LocalDate dataIn) {
        this.dataIn = dataIn;
        return this;
    }

    public OrderAddBindingModel setDataOut(LocalDate dataOut) {
        this.dataOut = dataOut;
        return this;
    }

    public OrderAddBindingModel setUserEntity(String userEntity) {
        this.userEntity = userEntity;
        return this;
    }

    public OrderAddBindingModel setProgressEnum(ProgressEnum progressEnum) {
        this.progressEnum = progressEnum;
        return this;
    }
}
