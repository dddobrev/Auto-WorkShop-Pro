package com.example.AutoWorkShop.domain.binding;

import com.example.AutoWorkShop.domain.entities.ManufacturerEntity;
import com.example.AutoWorkShop.domain.entities.RepairDetail;
import com.example.AutoWorkShop.domain.entities.SupplierEntity;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class AutoPartBindingModel {

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

    public AutoPartBindingModel() {
    }

    public Long getId() {
        return id;
    }

    @NotNull(message = "You must select supplier")
    public SupplierEntity getSupplier() {
        return supplier;
    }

    @NotNull
    public ManufacturerEntity getManufacturer() {
        return manufacturer;
    }

    @NotBlank
    @Size(min = 2)
    public String getName() {
        return name;
    }

    @NotNull
    @Size(min = 2)
    public String getPartNumber() {
        return partNumber;
    }

    public String getPartOeNumber() {
        return partOeNumber;
    }

    @NotNull
    @DecimalMin("0")
    public BigDecimal getPriceIn() {
        return priceIn;
    }

    @NotNull
    @DecimalMin("0")
    public BigDecimal getPriceOut() {
        return priceOut;
    }

    @NotNull
    @Min(value = 1)
    public Integer getPiece() {
        return piece;
    }

    public RepairDetail getRepairDetail() {
        return repairDetail;
    }

    public AutoPartBindingModel setId(Long id) {
        this.id = id;
        return this;
    }

    public AutoPartBindingModel setSupplier(SupplierEntity supplier) {
        this.supplier = supplier;
        return this;
    }

    public AutoPartBindingModel setManufacturer(ManufacturerEntity manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public AutoPartBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public AutoPartBindingModel setPartNumber(String partNumber) {
        this.partNumber = partNumber;
        return this;
    }

    public AutoPartBindingModel setPartOeNumber(String partOeNumber) {
        this.partOeNumber = partOeNumber;
        return this;
    }

    public AutoPartBindingModel setPriceIn(BigDecimal priceIn) {
        this.priceIn = priceIn;
        return this;
    }

    public AutoPartBindingModel setPriceOut(BigDecimal priceOut) {
        this.priceOut = priceOut;
        return this;
    }

    public AutoPartBindingModel setPiece(Integer piece) {
        this.piece = piece;
        return this;
    }

    public AutoPartBindingModel setRepairDetail(RepairDetail repairDetail) {
        this.repairDetail = repairDetail;
        return this;
    }

}
