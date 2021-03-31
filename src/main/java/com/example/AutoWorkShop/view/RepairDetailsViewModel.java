package com.example.AutoWorkShop.view;

import com.example.AutoWorkShop.domain.entities.AutoPartEntity;
import com.example.AutoWorkShop.domain.entities.RepairEntity;

import java.math.BigDecimal;

public class RepairDetailsViewModel {
    private Long id;
    private RepairEntity repair;
    private String repairDescription;
    private String remarks;
    private BigDecimal price;
    private AutoPartEntity autoParts;

    public RepairDetailsViewModel() {
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

    public RepairDetailsViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public RepairDetailsViewModel setRepair(RepairEntity repair) {
        this.repair = repair;
        return this;
    }

    public RepairDetailsViewModel setRepairDescription(String repairDescription) {
        this.repairDescription = repairDescription;
        return this;
    }

    public RepairDetailsViewModel setRemarks(String remarks) {
        this.remarks = remarks;
        return this;
    }

    public RepairDetailsViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public RepairDetailsViewModel setAutoParts(AutoPartEntity autoParts) {
        this.autoParts = autoParts;
        return this;
    }
}
