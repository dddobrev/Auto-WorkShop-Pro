package com.example.AutoWorkShop.view;

import com.example.AutoWorkShop.domain.entities.CarEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ClientViewModel {
    private Long id;
    private String firstName;
    private String secondName;
    private String telephone;
    @JsonIgnore
    private Set<CarEntity> carEntities = new HashSet<>();

    public ClientViewModel() {
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getTelephone() {
        return telephone;
    }

    public Set<CarEntity> getCarEntities() {
        return carEntities;
    }

    public ClientViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public ClientViewModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ClientViewModel setSecondName(String secondName) {
        this.secondName = secondName;
        return this;
    }

    public ClientViewModel setTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public ClientViewModel setCarEntities(Set<CarEntity> carEntities) {
        this.carEntities = carEntities;
        return this;
    }
}
