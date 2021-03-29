package com.example.AutoWorkShop.service.impl;

import com.example.AutoWorkShop.domain.entities.UserRoleEntity;
import com.example.AutoWorkShop.domain.entities.enums.UserRoleEnum;
import com.example.AutoWorkShop.repository.UserRoleRepository;
import com.example.AutoWorkShop.service.UserRoleService;

public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }


    @Override
    public UserRoleEntity findRole(UserRoleEnum userRoleEnum) {
        return userRoleRepository
                .findByRole(userRoleEnum)
                .orElse(null);
    }
}
