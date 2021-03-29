package com.example.AutoWorkShop.service;

import com.example.AutoWorkShop.domain.entities.UserEntity;
import com.example.AutoWorkShop.domain.entities.enums.UserRoleEnum;
import com.example.AutoWorkShop.domain.service.UserRegistrationServiceModel;
import com.example.AutoWorkShop.view.UserViewModel;

import java.util.List;

public interface UserService {
    void seedUsers();

    void registerAndLoginUser(UserRegistrationServiceModel serviceModel);

    boolean userNameExists(String username);

    List<String> getAllUsersNames();

    String findUserByUsername(String username);

    List<UserViewModel> findAllUsers();

    UserViewModel findUserViewByUsername(String username);

    void changeRole(String username, UserRoleEnum valueOf);

    UserViewModel findById(Long id);

    UserEntity findUserEntityByUsername(String username);
}
