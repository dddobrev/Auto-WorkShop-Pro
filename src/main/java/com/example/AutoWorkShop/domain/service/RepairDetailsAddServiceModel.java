package com.example.AutoWorkShop.domain.service;

import com.example.AutoWorkShop.domain.entities.AutoPartEntity;
import com.example.AutoWorkShop.domain.entities.RepairEntity;

import java.math.BigDecimal;

public class RepairDetailsAddServiceModel {
    private Long id;
    private RepairEntity repair;
    private String repairDescription;
    private String remarks;
    private BigDecimal price;
    private AutoPartEntity autoParts;

    public RepairDetailsAddServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public RepairEntity getRepair() {
        return repair;
    }

    public String getRepairDescription() {
        return repairDescription;
    }

    public String getRemarks() {
        return remarks;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AutoPartEntity getAutoParts() {
        return autoParts;
    }

    public RepairDetailsAddServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public RepairDetailsAddServiceModel setRepair(RepairEntity repair) {
        this.repair = repair;
        return this;
    }

    public RepairDetailsAddServiceModel setRepairDescription(String repairDescription) {
        this.repairDescription = repairDescription;
        return this;
    }

    public RepairDetailsAddServiceModel setRemarks(String remarks) {
        this.remarks = remarks;
        return this;
    }

    public RepairDetailsAddServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public RepairDetailsAddServiceModel setAutoParts(AutoPartEntity autoParts) {
        this.autoParts = autoParts;
        return this;
    }

}
