package com.example.AutoWorkShop.domain.entities;

import com.example.AutoWorkShop.domain.entities.enums.ClassificationEnum;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "repair")
public class RepairEntity extends BaseEntity {

    private CarEntity car;
    private Integer oldKm;
    private Integer newKm;
    private LocalDate dataInGarage;
    private LocalDate dataOutGarage;
    private ClassificationEnum classificationEnum;
    private UserEntity userEntity;
    private Set<RepairDetail> repairDetails = new HashSet<>();


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

    @Enumerated(EnumType.STRING)
    public ClassificationEnum getClassificationEnum() {
        return classificationEnum;
    }

    @ManyToOne
    public UserEntity getUserEntity() {
        return userEntity;
    }

//    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @OneToMany(mappedBy = "repair")
    public Set<RepairDetail> getRepairDetails() {
        return repairDetails;
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

    public RepairEntity setClassificationEnum(ClassificationEnum classificationEnum) {
        this.classificationEnum = classificationEnum;
        return this;
    }

    public RepairEntity setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
        return this;
    }

    public RepairEntity setRepairDetails(Set<RepairDetail> repairDetails) {
        this.repairDetails = repairDetails;
        return this;
    }
//    public RepairEntity addDetails(RepairDetail repairDetail) {
//        this.repairDetails.add(repairDetail);
//        return this;
//    }
}
