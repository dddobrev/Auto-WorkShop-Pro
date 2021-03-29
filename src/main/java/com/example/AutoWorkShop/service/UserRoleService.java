package com.example.AutoWorkShop.service;

import com.example.AutoWorkShop.domain.entities.UserRoleEntity;
import com.example.AutoWorkShop.domain.entities.enums.UserRoleEnum;

public interface UserRoleService {
    UserRoleEntity findRole(UserRoleEnum userRoleEnum);
}
