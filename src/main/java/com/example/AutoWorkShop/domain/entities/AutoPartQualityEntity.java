package com.example.AutoWorkShop.domain.entities;

import javax.persistence.*;

@Entity(name = "auto_part_quality")
public class AutoPartQualityEntity extends BaseEntity{
    private AutoPartEntity autoPart;
    private Integer partWorkload;
    private Integer partKm;
    private Integer score;

    public AutoPartQualityEntity() {
    }

    @ManyToOne(targetEntity = AutoPartEntity.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "auto_parts_id", referencedColumnName = "id")
    public AutoPartEntity getAutoPart() {
        return autoPart;
    }

    @Column(name = "part_workload")
    public Integer getPartWorkload() {
        return partWorkload;
    }

    @Column(name = "part_km")
    public Integer getPartKm() {
        return partKm;
    }

    @Column(name = "score")
    public Integer getScore() {
        return score;
    }

    public AutoPartQualityEntity setAutoPart(AutoPartEntity autoPart) {
        this.autoPart = autoPart;
        return this;
    }

    public AutoPartQualityEntity setPartWorkload(Integer partWorkload) {
        this.partWorkload = partWorkload;
        return this;
    }

    public AutoPartQualityEntity setPartKm(Integer partKm) {
        this.partKm = partKm;
        return this;
    }

    public AutoPartQualityEntity setScore(Integer score) {
        this.score = score;
        return this;
    }
}
