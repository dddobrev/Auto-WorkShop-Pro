package com.example.AutoWorkShop.domain.binding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class ClientAddBindingModel {
    private Long id;
    private String firstName;
    private String secondName;
    private String telephone;

    public ClientAddBindingModel() {
    }

    public Long getId() {
        return id;
    }

    @NotBlank(message = "First name can cannot be empty")
    @Size(min = 2)
    public String getFirstName() {
        return firstName;
    }

    @NotBlank
    public String getSecondName() {
        return secondName;
    }

    @NotBlank(message = "Telephone number can cannot be empty")
    @Size(min = 4)
    public String getTelephone() {
        return telephone;
    }

    public ClientAddBindingModel setId(Long id) {
        this.id = id;
        return this;
    }

    public ClientAddBindingModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ClientAddBindingModel setSecondName(String secondName) {
        this.secondName = secondName;
        return this;
    }

    public ClientAddBindingModel setTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }
}
