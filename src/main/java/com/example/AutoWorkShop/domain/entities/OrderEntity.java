package com.example.AutoWorkShop.domain.entities;

import com.example.AutoWorkShop.domain.entities.enums.ClassificationEnum;
import com.example.AutoWorkShop.domain.entities.enums.ProgressEnum;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "order_entities")
public class OrderEntity extends BaseEntity {
    private LocalDate dataOrder;
    private CarEntity car;
    private ClassificationEnum classificationEnum;
    private String comment;
    private LocalDate dataIn;
    private LocalDate dataOut;
    private UserEntity userEntity;
    private ProgressEnum progressEnum;
//    private boolean isActive = true;

    public OrderEntity() {
    }

    @Column(name = "data_order")
    public LocalDate getDataOrder() {
        return dataOrder;
    }

    @ManyToOne
    public CarEntity getCar() {
        return car;
    }

    @Enumerated(EnumType.STRING)
    public ClassificationEnum getClassificationEnum() {
        return classificationEnum;
    }

    @Column(name = "comment", columnDefinition = "TEXT")
    public String getComment() {
        return comment;
    }

    @Column(name = "data_in")
    public LocalDate getDataIn() {
        return dataIn;
    }

    @Column(name = "data_out")
    public LocalDate getDataOut() {
        return dataOut;
    }

    @ManyToOne
    public UserEntity getUserEntity() {
        return userEntity;
    }

    @Enumerated(EnumType.STRING)
    public ProgressEnum getProgressEnum() {
        return progressEnum;
    }

//    @Column(name = "status")
//    public boolean isActive() {
//        return isActive;
//    }

    public OrderEntity setDataOrder(LocalDate dataOrder) {
        this.dataOrder = dataOrder;
        return this;
    }

    public OrderEntity setCar(CarEntity carEntity) {
        this.car = carEntity;
        return this;
    }

    public OrderEntity setClassificationEnum(ClassificationEnum classificationEnum) {
        this.classificationEnum = classificationEnum;
        return this;
    }

    public OrderEntity setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public OrderEntity setDataIn(LocalDate dataIn) {
        this.dataIn = dataIn;
        return this;
    }

    public OrderEntity setDataOut(LocalDate dataOut) {
        this.dataOut = dataOut;
        return this;
    }

    public OrderEntity setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
        return this;
    }

    public OrderEntity setProgressEnum(ProgressEnum progressEnum) {
        this.progressEnum = progressEnum;
        return this;
    }

//    public OrderEntity setActive(boolean active) {
//        isActive = active;
//        return this;
//    }
}
