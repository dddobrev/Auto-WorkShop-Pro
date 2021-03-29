package com.example.AutoWorkShop.domain.entities;

import javax.persistence.*;

@Entity(name = "warehouse")
public class WarehouseEntity extends BaseEntity {
    private AutoPartEntity autoPartsEntity;
    private Integer piece;

    public WarehouseEntity() {
    }

    @ManyToOne(targetEntity = AutoPartEntity.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "auto_parts_id", referencedColumnName = "id")
    public AutoPartEntity getAutoParts() {
        return autoPartsEntity;
    }

    @Column(name = "piece")
    public Integer getPiece() {
        return this.piece;
    }

    public void setAutoParts(AutoPartEntity autoPartsEntity) {
        this.autoPartsEntity = autoPartsEntity;
    }

    public void setPiece(Integer piece) {
        this.piece = piece;
    }
}
