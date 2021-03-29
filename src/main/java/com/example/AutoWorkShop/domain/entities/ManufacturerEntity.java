package com.example.AutoWorkShop.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "manufacturer")
public class ManufacturerEntity extends BaseEntity{
    private String manufacturerName;
    private Set<AutoPartEntity> autoParts = new HashSet<>();

    public ManufacturerEntity() {
    }

    public ManufacturerEntity(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    @Column(name = "manufacturer_name", nullable = false)
    public String getManufacturerName() {
        return manufacturerName;
    }

    @OneToMany(mappedBy = "manufacturer")
    public Set<AutoPartEntity> getAutoParts() {
        return autoParts;
    }

    public ManufacturerEntity setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
        return this;
    }

    public ManufacturerEntity setAutoParts(Set<AutoPartEntity> autoParts) {
        this.autoParts = autoParts;
        return this;
    }
}
