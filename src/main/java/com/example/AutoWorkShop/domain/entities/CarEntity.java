package com.example.AutoWorkShop.domain.entities;

import com.example.AutoWorkShop.domain.entities.enums.FuelEnum;
import com.example.AutoWorkShop.domain.entities.enums.TransmissionEnum;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

@Entity(name = "cars")
public class CarEntity extends BaseEntity {
    private String regNumber;
    private String vin;
    private String brand;
    private String model;
    private String coupeModel;
    private String engine;
    private Integer volume;
    private Integer power;
    private FuelEnum fuel;
    private TransmissionEnum transmission;
    private LocalDate releaseDate;
    private ClientEntity client;
    private Integer mileage;
    private Integer mileageDifferent;
    private UserEntity userEntity;
    private Set<OrderEntity> orders = new HashSet<>();
    private Set<RepairEntity> repairs = new LinkedHashSet<>();;

    public CarEntity() {
    }

    @Column(name = "reg_number")
    public String getRegNumber() {
        return regNumber;
    }

    @Column(name = "vin", unique = true, nullable = false)
    public String getVin() {
        return vin;
    }

    @Column(name = "brand", nullable = false)
    public String getBrand() {
        return brand;
    }

    @Column(name = "model")
    public String getModel() {
        return model;
    }

    @Column(name="coupe_model")
    public String getCoupeModel() {
        return coupeModel;
    }

    @Column(name = "engine")
    public String getEngine() {
        return engine;
    }

    @Column(name = "volume")
    public Integer getVolume() {
        return volume;
    }

    @Column(name = "power_ps")
    public Integer getPower() {
        return power;
    }

    @Enumerated(EnumType.STRING)
    public FuelEnum getFuel() {
        return fuel;
    }

    @Enumerated(EnumType.STRING)
    public TransmissionEnum getTransmission() {
        return transmission;
    }

    @Column(name = "release_date")
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    @ManyToOne
    public ClientEntity getClient() {
        return client;
    }

    @Column(name = "miliage")
    public Integer getMileage() {
        return mileage;
    }

    @Column(name = "miliage_diffrent")
    public Integer getMileageDifferent() {
        return mileageDifferent;
    }

    @OneToMany(mappedBy = "car")
    public Set<OrderEntity> getOrders() {
        return orders;
    }

    @OneToMany(mappedBy = "car")
    public Set<RepairEntity> getRepairs() {
        return repairs;
    }

    @ManyToOne
    public UserEntity getUserEntity() {
        return userEntity;
    }

    public CarEntity setRegNumber(String regNumber) {
        this.regNumber = regNumber;
        return this;
    }

    public CarEntity setVin(String vin) {
        this.vin = vin;
        return this;
    }

    public CarEntity setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public CarEntity setModel(String model) {
        this.model = model;
        return this;
    }

    public CarEntity setCoupeModel(String coupeModel) {
        this.coupeModel = coupeModel;
        return this;
    }

    public CarEntity setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public CarEntity setVolume(Integer volume) {
        this.volume = volume;
        return this;
    }

    public CarEntity setPower(Integer power) {
        this.power = power;
        return this;
    }

    public CarEntity setFuel(FuelEnum fuel) {
        this.fuel = fuel;
        return this;
    }

    public CarEntity setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public CarEntity setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public CarEntity setClient(ClientEntity client) {
        this.client = client;
        return this;
    }

    public CarEntity setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public CarEntity setMileageDifferent(Integer mileageDifferent) {
        this.mileageDifferent = mileageDifferent;
        return this;
    }

    public CarEntity setOrders(Set<OrderEntity> orders) {
        this.orders = orders;
        return this;
    }

    public CarEntity setRepairs(Set<RepairEntity> repairs) {
        this.repairs = repairs;
        return this;
    }

    public CarEntity setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
        return this;
    }
}
