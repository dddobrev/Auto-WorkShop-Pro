package com.example.AutoWorkShop.domain.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private boolean isActive = true;
    private String imageUrl;
    private List<UserRoleEntity> userRoles = new ArrayList<>();

    public UserEntity() {
    }

    @Column(name = "names", nullable = false, unique = true)
    public String getUsername() {
        return username;
    }

    @Column(name = "passwods", nullable = false)
    public String getPassword() {
        return password;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    @Column(name = "image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    @Column(name = "active")
    public boolean isActive() {
        return isActive;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    public List<UserRoleEntity> getUserRoles() {
        return userRoles;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserEntity setActive(boolean active) {
        isActive = active;
        return this;
    }

    public UserEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public UserEntity setUserRoles(
            List<UserRoleEntity> userRoles) {
        this.userRoles = userRoles;
        return this;
    }

    public UserEntity addRole(UserRoleEntity roleEntity) {
        this.userRoles.add(roleEntity);
        return this;
    }
}
