package com.example.AutoWorkShop.view;

import com.example.AutoWorkShop.domain.entities.ClientEntity;
import com.example.AutoWorkShop.domain.entities.RepairEntity;
import com.example.AutoWorkShop.domain.entities.enums.FuelEnum;
import com.example.AutoWorkShop.domain.entities.enums.TransmissionEnum;
import net.minidev.json.annotate.JsonIgnore;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class CarViewModelWithRepairs {
    private Long id;
    private String regNumber;
    private String vin;
    private String brand;
    private String model;
    private String engine;
    private Integer volume;
    private Integer power;
    private FuelEnum fuel;
    private TransmissionEnum transmission;
    private LocalDate releaseDate;
    private ClientEntity clientEntity;
    private Integer mileage;
    private Set<RepairEntity> repairs = new LinkedHashSet<>();;

    public CarViewModelWithRepairs() {
    }

    public Long getId() {
        return id;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public String getVin() {
        return vin;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getEngine() {
        return engine;
    }

    public Integer getVolume() {
        return volume;
    }

    public Integer getPower() {
        return power;
    }

    public FuelEnum getFuel() {
        return fuel;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public ClientEntity getClientEntity() {
        return clientEntity;
    }

    public Integer getMileage() {
        return mileage;
    }

    public Set<RepairEntity> getRepairs() {
        return repairs;
    }

    public CarViewModelWithRepairs setId(Long id) {
        this.id = id;
        return this;
    }

    public CarViewModelWithRepairs setRegNumber(String regNumber) {
        this.regNumber = regNumber;
        return this;
    }

    public CarViewModelWithRepairs setVin(String vin) {
        this.vin = vin;
        return this;
    }

    public CarViewModelWithRepairs setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public CarViewModelWithRepairs setModel(String model) {
        this.model = model;
        return this;
    }

    public CarViewModelWithRepairs setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public CarViewModelWithRepairs setVolume(Integer volume) {
        this.volume = volume;
        return this;
    }

    public CarViewModelWithRepairs setPower(Integer power) {
        this.power = power;
        return this;
    }

    public CarViewModelWithRepairs setFuel(FuelEnum fuel) {
        this.fuel = fuel;
        return this;
    }

    public CarViewModelWithRepairs setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public CarViewModelWithRepairs setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public CarViewModelWithRepairs setClientEntity(ClientEntity clientEntity) {
        this.clientEntity = clientEntity;
        return this;
    }

    public CarViewModelWithRepairs setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public CarViewModelWithRepairs setRepairs(Set<RepairEntity> repairs) {
        this.repairs = repairs;
        return this;
    }
}
