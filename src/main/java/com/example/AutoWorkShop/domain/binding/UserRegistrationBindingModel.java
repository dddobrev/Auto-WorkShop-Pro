package com.example.AutoWorkShop.domain.binding;

import com.example.AutoWorkShop.domain.validators.FieldMatch;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@FieldMatch(
        first = "password",
        second = "confirmPassword"
)
public class UserRegistrationBindingModel {

    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String confirmPassword;

    public UserRegistrationBindingModel() {
    }

    @NotEmpty
    @Size(min = 3)
    public String getUsername() {
        return username;
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

    @Size(min = 5, max = 20)
    public String getPassword() {
        return password;
    }

    @NotEmpty
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegistrationBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public UserRegistrationBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserRegistrationBindingModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserRegistrationBindingModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserRegistrationBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserRegistrationBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
