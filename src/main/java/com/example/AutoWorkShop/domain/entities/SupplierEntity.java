package com.example.AutoWorkShop.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "supplier")
public class SupplierEntity extends BaseEntity{
    private String supplierName;
    private String supplierTelephone;
    private String supplierContactPerson;

    public SupplierEntity() {
    }

    @Column(name = "supplier_name")
    public String getSupplierName() {
        return supplierName;
    }

    @Column(name = "supplier_telephone")
    public String getSupplierTelephone() {
        return supplierTelephone;
    }

    @Column(name = "supplier_contact_person")
    public String getSupplierContactPerson() {
        return supplierContactPerson;
    }

    public SupplierEntity setSupplierName(String supplierName) {
        this.supplierName = supplierName;
        return this;
    }

    public SupplierEntity setSupplierTelephone(String supplierTelephone) {
        this.supplierTelephone = supplierTelephone;
        return this;
    }

    public SupplierEntity setSupplierContactPerson(String supplierContactPerson) {
        this.supplierContactPerson = supplierContactPerson;
        return this;
    }
}
