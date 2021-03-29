package com.example.AutoWorkShop.domain.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "repair_details")
public class RepairDetail extends BaseEntity{
    private RepairEntity repair;
    private String repairDescription;
    private String remarks;
    private BigDecimal price;
    private AutoPartEntity autoParts;

    public RepairDetail() {
    }

    @ManyToOne
    public RepairEntity getRepair() {
        return repair;
    }

    @Column(name = "repair_description")
    public String getRepairDescription() {
        return repairDescription;
    }

    @Column(name = "remarks", columnDefinition = "TEXT")
    public String getRemarks() {
        return remarks;
    }

    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    @ManyToOne
    public AutoPartEntity getAutoParts() {
        return autoParts;
    }

    public RepairDetail setRepair(RepairEntity repair) {
        this.repair = repair;
        return this;
    }

    public RepairDetail setRepairDescription(String repairDescription) {
        this.repairDescription = repairDescription;
        return this;
    }

    public RepairDetail setRemarks(String remarks) {
        this.remarks = remarks;
        return this;
    }

    public RepairDetail setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public RepairDetail setAutoParts(AutoPartEntity autoParts) {
        this.autoParts = autoParts;
        return this;
    }
}
