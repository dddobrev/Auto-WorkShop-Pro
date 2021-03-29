package com.example.AutoWorkShop.domain.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "repair")
public class RepairEntity extends  BaseEntity{

    private CarEntity car;
    private Integer oldKm;
    private Integer newKm;
    private LocalDate dataInGarage;
    private LocalDate dataOutGarage;
    private UserEntity userEntity;


    public RepairEntity() {
    }

    @ManyToOne
    public CarEntity getCar() {
        return car;
    }

    @Column(name = "old_km")
    public Integer getOldKm() {
        return oldKm;
    }

    @Column(name = "new_km")
    public Integer getNewKm() {
        return newKm;
    }

    @Column(name = "data_in_garage")
    public LocalDate getDataInGarage() {
        return dataInGarage;
    }

    @Column(name = "data_out_garage")
    public LocalDate getDataOutGarage() {
        return dataOutGarage;
    }

    @ManyToOne
    public UserEntity getUserEntity() {
        return userEntity;
    }

    public RepairEntity setCar(CarEntity car) {
        this.car = car;
        return this;
    }

    public RepairEntity setOldKm(Integer oldKm) {
        this.oldKm = oldKm;
        return this;
    }

    public RepairEntity setNewKm(Integer newKm) {
        this.newKm = newKm;
        return this;
    }

    public RepairEntity setDataInGarage(LocalDate dataInGarage) {
        this.dataInGarage = dataInGarage;
        return this;
    }

    public RepairEntity setDataOutGarage(LocalDate dataOutGarage) {
        this.dataOutGarage = dataOutGarage;
        return this;
    }

    public RepairEntity setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
        return this;
    }
}
