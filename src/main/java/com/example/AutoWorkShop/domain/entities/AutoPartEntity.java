package com.example.AutoWorkShop.domain.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity(name = "auto_parts")
public class AutoPartEntity extends BaseEntity{

    private SupplierEntity supplier;
    private ManufacturerEntity manufacturer;
    private String name;
    private String partNumber;
    private String partOeNumber;
    private BigDecimal priceIn;
    private BigDecimal priceOut;
//    private Set<RepairDetail> repairDetail;
    private Integer piece;
//    private Set<WarehouseEntity> warehouses;

    public AutoPartEntity() {
    }

    @ManyToOne
    public SupplierEntity getSupplier() {
        return supplier;
    }

    @ManyToOne
    public ManufacturerEntity getManufacturer() {
        return manufacturer;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Column(name = "part_number", nullable = false)
    public String getPartNumber() {
        return partNumber;
    }

    @Column(name = "part_oe_number")
    public String getPartOeNumber() {
        return partOeNumber;
    }

    @Column(name = "price_in")
    public BigDecimal getPriceIn() {
        return priceIn;
    }

    @Column(name = "price_out")
    public BigDecimal getPriceOut() {
        return priceOut;
    }

//    @OneToMany
//    public Set<RepairDetail> getRepairDetail() {
//        return repairDetail;
//    }

    @Column(name = "pieces")
    public Integer getPiece() {
        return piece;
    }

//    @OneToMany(mappedBy = "autoParts")
//    public Set<WarehouseEntity> getWarehouses() {
//        return warehouses;
//    }

    public AutoPartEntity setSupplier(SupplierEntity supplier) {
        this.supplier = supplier;
        return this;
    }

    public AutoPartEntity setManufacturer(ManufacturerEntity manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public AutoPartEntity setName(String name) {
        this.name = name;
        return this;
    }

    public AutoPartEntity setPartNumber(String partNumber) {
        this.partNumber = partNumber;
        return this;
    }

    public AutoPartEntity setPartOeNumber(String partOeNumber) {
        this.partOeNumber = partOeNumber;
        return this;
    }

    public AutoPartEntity setPriceIn(BigDecimal priceIn) {
        this.priceIn = priceIn;
        return this;
    }

    public AutoPartEntity setPriceOut(BigDecimal priceOut) {
        this.priceOut = priceOut;
        return this;
    }

//    public AutoPartEntity setRepairDetail(Set<RepairDetail> repairDetail) {
//        this.repairDetail = repairDetail;
//        return this;
//    }

    public AutoPartEntity setPiece(Integer piece) {
        this.piece = piece;
        return this;
    }

//    public AutoPartEntity setWarehouses(Set<WarehouseEntity> warehouses) {
//        this.warehouses = warehouses;
//        return this;
//    }
}
