package com.example.AutoWorkShop.domain.service;

public class ClientAddServiceModel {
    private Long id;
    private String firstName;
    private String secondName;
    private String telephone;

    public ClientAddServiceModel() {
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

    public ClientAddServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public ClientAddServiceModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ClientAddServiceModel setSecondName(String secondName) {
        this.secondName = secondName;
        return this;
    }

    public ClientAddServiceModel setTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }
}
