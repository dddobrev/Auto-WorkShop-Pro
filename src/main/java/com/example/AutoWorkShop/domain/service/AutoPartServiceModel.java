package com.example.AutoWorkShop.domain.service;

import com.example.AutoWorkShop.domain.entities.ManufacturerEntity;
import com.example.AutoWorkShop.domain.entities.RepairDetail;
import com.example.AutoWorkShop.domain.entities.SupplierEntity;

import java.math.BigDecimal;

public class AutoPartServiceModel {

    private Long id;
    private SupplierEntity supplier;
    private ManufacturerEntity manufacturer;
    private String name;
    private String partNumber;
    private String partOeNumber;
    private BigDecimal priceIn;
    private BigDecimal priceOut;
    private Integer piece;
    private RepairDetail repairDetail;


    public AutoPartServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public SupplierEntity getSupplier() {
        return supplier;
    }

    public ManufacturerEntity getManufacturer() {
        return manufacturer;
    }

    public String getName() {
        return name;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public String getPartOeNumber() {
        return partOeNumber;
    }

    public BigDecimal getPriceIn() {
        return priceIn;
    }

    public BigDecimal getPriceOut() {
        return priceOut;
    }

    public Integer getPiece() {
        return piece;
    }

    public RepairDetail getRepairDetail() {
        return repairDetail;
    }


    public AutoPartServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public AutoPartServiceModel setSupplier(SupplierEntity supplier) {
        this.supplier = supplier;
        return this;
    }

    public AutoPartServiceModel setManufacturer(ManufacturerEntity manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public AutoPartServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public AutoPartServiceModel setPartNumber(String partNumber) {
        this.partNumber = partNumber;
        return this;
    }

    public AutoPartServiceModel setPartOeNumber(String partOeNumber) {
        this.partOeNumber = partOeNumber;
        return this;
    }

    public AutoPartServiceModel setPriceIn(BigDecimal priceIn) {
        this.priceIn = priceIn;
        return this;
    }

    public AutoPartServiceModel setPriceOut(BigDecimal priceOut) {
        this.priceOut = priceOut;
        return this;
    }

    public AutoPartServiceModel setPiece(Integer piece) {
        this.piece = piece;
        return this;
    }

    public AutoPartServiceModel setRepairDetail(RepairDetail repairDetail) {
        this.repairDetail = repairDetail;
        return this;
    }

}
