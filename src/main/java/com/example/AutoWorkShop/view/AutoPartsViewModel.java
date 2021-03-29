package com.example.AutoWorkShop.view;

import com.example.AutoWorkShop.domain.entities.ManufacturerEntity;
import com.example.AutoWorkShop.domain.entities.RepairDetail;
import com.example.AutoWorkShop.domain.entities.RepairEntity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public class AutoPartsViewModel {

    private Long id;
    private ManufacturerEntity manufacturer;
    private String name;
    private String partNumber;
    private String partOeNumber;
    private BigDecimal priceIn;
    private BigDecimal priceOut;
    private Integer piece;
    private List<RepairEntity> repairEntities;


    public AutoPartsViewModel() {
    }

    public Long getId() {
        return id;
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

    public List<RepairEntity> getRepairEntities() {
        return repairEntities;
    }

    public AutoPartsViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public AutoPartsViewModel setManufacturer(ManufacturerEntity manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public AutoPartsViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getPiece() {
        return piece;
    }

    public AutoPartsViewModel setPartNumber(String partNumber) {
        this.partNumber = partNumber;
        return this;
    }

    public AutoPartsViewModel setPartOeNumber(String partOeNumber) {
        this.partOeNumber = partOeNumber;
        return this;
    }

    public AutoPartsViewModel setPriceIn(BigDecimal priceIn) {
        this.priceIn = priceIn;
        return this;
    }

    public AutoPartsViewModel setPriceOut(BigDecimal priceOut) {
        this.priceOut = priceOut;
        return this;
    }

    public AutoPartsViewModel setPiece(Integer piece) {
        this.piece = piece;
        return this;
    }

    public AutoPartsViewModel setRepairEntities(List<RepairEntity> repairEntities) {
        this.repairEntities = repairEntities;
        return this;
    }
}
