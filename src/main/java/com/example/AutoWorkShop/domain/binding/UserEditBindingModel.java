package com.example.AutoWorkShop.domain.binding;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserEditBindingModel {

    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String imageUrl;

    public UserEditBindingModel() {
    }

    public Long getId() {
        return id;
    }

    @NotEmpty
    @Email
    public String getEmail() {
        return email;
    }

    @NotEmpty
    @Size(min = 2)
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public UserEditBindingModel setId(Long id) {
        this.id = id;
        return this;
    }

    public UserEditBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserEditBindingModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserEditBindingModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserEditBindingModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
