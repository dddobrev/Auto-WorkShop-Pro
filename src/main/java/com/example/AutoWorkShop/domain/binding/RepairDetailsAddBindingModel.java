package com.example.AutoWorkShop.domain.binding;

import com.example.AutoWorkShop.domain.entities.AutoPartEntity;
import com.example.AutoWorkShop.domain.entities.RepairEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class RepairDetailsAddBindingModel {
    private Long id;
    private RepairEntity repair;
    private String repairDescription;
    private String remarks;
    private BigDecimal price;
    private AutoPartEntity autoParts;

    public RepairDetailsAddBindingModel() {
    }

    public Long getId() {
        return id;
    }

    @NotNull
    public RepairEntity getRepair() {
        return repair;
    }

    @NotBlank
    @Size(min = 2)
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

    public RepairDetailsAddBindingModel setId(Long id) {
        this.id = id;
        return this;
    }

    public RepairDetailsAddBindingModel setRepair(RepairEntity repair) {
        this.repair = repair;
        return this;
    }

    public RepairDetailsAddBindingModel setRepairDescription(String repairDescription) {
        this.repairDescription = repairDescription;
        return this;
    }

    public RepairDetailsAddBindingModel setRemarks(String remarks) {
        this.remarks = remarks;
        return this;
    }

    public RepairDetailsAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public RepairDetailsAddBindingModel setAutoParts(AutoPartEntity autoParts) {
        this.autoParts = autoParts;
        return this;
    }
}
