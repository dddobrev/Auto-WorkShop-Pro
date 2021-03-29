package com.example.AutoWorkShop.repository;

import com.example.AutoWorkShop.domain.entities.UserRoleEntity;
import com.example.AutoWorkShop.domain.entities.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {
    Optional<UserRoleEntity> findByRole(UserRoleEnum role);
}
