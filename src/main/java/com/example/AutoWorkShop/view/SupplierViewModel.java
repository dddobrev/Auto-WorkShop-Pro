package com.example.AutoWorkShop.view;

public class SupplierViewModel {
    private Long id;
    private String supplierName;
    private String supplierTelephone;
    private String supplierContactPerson;

    public SupplierViewModel() {
    }

    public Long getId() {
        return id;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getSupplierTelephone() {
        return supplierTelephone;
    }

    public String getSupplierContactPerson() {
        return supplierContactPerson;
    }

    public SupplierViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public SupplierViewModel setSupplierName(String supplierName) {
        this.supplierName = supplierName;
        return this;
    }

    public SupplierViewModel setSupplierTelephone(String supplierTelephone) {
        this.supplierTelephone = supplierTelephone;
        return this;
    }

    public SupplierViewModel setSupplierContactPerson(String supplierContactPerson) {
        this.supplierContactPerson = supplierContactPerson;
        return this;
    }
}
