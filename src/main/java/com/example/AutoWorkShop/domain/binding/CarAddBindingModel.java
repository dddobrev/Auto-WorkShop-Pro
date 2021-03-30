package com.example.AutoWorkShop.domain.binding;

import com.example.AutoWorkShop.domain.entities.ClientEntity;
import com.example.AutoWorkShop.domain.entities.enums.FuelEnum;
import com.example.AutoWorkShop.domain.entities.enums.TransmissionEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class CarAddBindingModel {
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

    public CarAddBindingModel() {
    }

    public Long getId() {
        return id;
    }

    @NotEmpty
    @Size(min = 4)
    public String getRegNumber() {
        return regNumber;
    }

    @NotEmpty
    @Size(min = 14)
    public String getVin() {
        return vin;
    }

    @NotEmpty
    @Size(min = 2)
    public String getBrand() {
        return brand;
    }

    @NotEmpty
    @Size(min = 1)
    public String getModel() {
        return model;
    }

    @NotEmpty
    public String getCoupeModel() {
        return coupeModel;
    }

    @NotEmpty
    @Size(min = 2)
    public String getEngine() {
        return engine;
    }

    @NotNull
    @PositiveOrZero
    public Integer getVolume() {
        return volume;
    }

    @NotNull
    @PositiveOrZero
    public Integer getPower() {
        return power;
    }

    @NotNull
    public FuelEnum getFuel() {
        return fuel;
    }

    @NotNull
    public TransmissionEnum getTransmission() {
        return transmission;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "The date cannot be in the future")
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    @NotNull
    public ClientEntity getClientEntity() {
        return clientEntity;
    }

    @NotNull
    @PositiveOrZero
    public Integer getMileage() {
        return mileage;
    }

    public CarAddBindingModel setId(Long id) {
        this.id = id;
        return this;
    }

    public CarAddBindingModel setRegNumber(String regNumber) {
        this.regNumber = regNumber;
        return this;
    }

    public CarAddBindingModel setVin(String vin) {
        this.vin = vin;
        return this;
    }

    public CarAddBindingModel setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public CarAddBindingModel setModel(String model) {
        this.model = model;
        return this;
    }

    public CarAddBindingModel setCoupeModel(String coupeModel) {
        this.coupeModel = coupeModel;
        return this;
    }

    public CarAddBindingModel setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public CarAddBindingModel setVolume(Integer volume) {
        this.volume = volume;
        return this;
    }

    public CarAddBindingModel setPower(Integer power) {
        this.power = power;
        return this;
    }

    public CarAddBindingModel setFuel(FuelEnum fuel) {
        this.fuel = fuel;
        return this;
    }

    public CarAddBindingModel setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public CarAddBindingModel setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public CarAddBindingModel setClientEntity(ClientEntity clientEntity) {
        this.clientEntity = clientEntity;
        return this;
    }

    public CarAddBindingModel setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }
}
