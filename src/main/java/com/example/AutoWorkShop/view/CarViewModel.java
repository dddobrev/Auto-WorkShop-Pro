package com.example.AutoWorkShop.view;

import com.example.AutoWorkShop.domain.entities.ClientEntity;
import com.example.AutoWorkShop.domain.entities.enums.FuelEnum;
import com.example.AutoWorkShop.domain.entities.enums.TransmissionEnum;

import java.time.LocalDate;

public class CarViewModel {
    private Long id;
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
    private ClientEntity clientEntity;
    private Integer mileage;

    public CarViewModel() {
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

    public String getCoupeModel() {
        return coupeModel;
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

    public CarViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public CarViewModel setRegNumber(String regNumber) {
        this.regNumber = regNumber;
        return this;
    }

    public CarViewModel setVin(String vin) {
        this.vin = vin;
        return this;
    }

    public CarViewModel setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public CarViewModel setModel(String model) {
        this.model = model;
        return this;
    }

    public CarViewModel setCoupeModel(String coupeModel) {
        this.coupeModel = coupeModel;
        return this;
    }

    public CarViewModel setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public CarViewModel setVolume(Integer volume) {
        this.volume = volume;
        return this;
    }

    public CarViewModel setPower(Integer power) {
        this.power = power;
        return this;
    }

    public CarViewModel setFuel(FuelEnum fuel) {
        this.fuel = fuel;
        return this;
    }

    public CarViewModel setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public CarViewModel setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public CarViewModel setClientEntity(ClientEntity clientEntity) {
        this.clientEntity = clientEntity;
        return this;
    }

    public CarViewModel setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }
}
