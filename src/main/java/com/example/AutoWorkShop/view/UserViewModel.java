package com.example.AutoWorkShop.view;

import com.example.AutoWorkShop.domain.entities.UserRoleEntity;

import java.util.ArrayList;
import java.util.List;

public class UserViewModel {

//    private Long id;
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private boolean isActive;
    private String imageUrl;
    private List<UserRoleEntity> userRoles = new ArrayList<>();

    public UserViewModel() {
    }

//    public Long getId() {
//        return id;
//    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
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

    public boolean isActive() {
        return isActive;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public List<UserRoleEntity> getUserRoles() {
        return userRoles;
    }

//    public UserViewModel setId(Long id) {
//        this.id = id;
//        return this;
//    }

    public UserViewModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public UserViewModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserViewModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserViewModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserViewModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserViewModel setActive(boolean active) {
        isActive = active;
        return this;
    }

    public UserViewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public UserViewModel setUserRoles(List<UserRoleEntity> userRoles) {
        this.userRoles = userRoles;
        return this;
    }
}
