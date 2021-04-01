package com.example.AutoWorkShop.domain.service;

public class UserEditServiceModel {

    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String imageUrl;

    public UserEditServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public UserEditServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public UserEditServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserEditServiceModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserEditServiceModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserEditServiceModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
