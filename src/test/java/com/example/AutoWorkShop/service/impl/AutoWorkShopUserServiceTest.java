package com.example.AutoWorkShop.service.impl;

import com.example.AutoWorkShop.domain.entities.UserEntity;
import com.example.AutoWorkShop.domain.entities.UserRoleEntity;
import com.example.AutoWorkShop.domain.entities.enums.UserRoleEnum;
import com.example.AutoWorkShop.repository.UserRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@ExtendWith(MockitoExtension.class)
@Transactional
public class AutoWorkShopUserServiceTest {

    private AutoWorkShopUserService serviceToTest;

    @Mock
    UserRepository mockUserRepository;

    @BeforeEach
    public void setUp() {
        serviceToTest = new AutoWorkShopUserService(mockUserRepository);
    }

    @Test
    void testUserNotFound() {
        Assertions.assertThrows(
                UsernameNotFoundException.class, () -> {
                    serviceToTest.loadUserByUsername("user_not_found");
                }
        );
    }

    @Test
    void testExistingUser() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("mitko");
        userEntity.setPassword("123456");

        UserRoleEntity roleUser = new UserRoleEntity();
        roleUser.setRole(UserRoleEnum.USER);
        UserRoleEntity roleAdmin = new UserRoleEntity();
        roleAdmin.setRole(UserRoleEnum.ADMIN);

        userEntity.setUserRoles(List.of(roleAdmin, roleUser));
        userEntity.setUsername("mitko");

        Mockito.when(mockUserRepository.findByUsername("mitko"))
                .thenReturn(Optional.of(userEntity));

        UserDetails userDetails = serviceToTest.loadUserByUsername("mitko");

        Assertions.assertEquals(userEntity.getUsername(), userDetails.getUsername());
        Assertions.assertEquals(2, userDetails.getAuthorities().size());

        List<String> authorities = userDetails.
                getAuthorities().
                stream().
                map(GrantedAuthority::getAuthority).
                collect(Collectors.toList());
        Assertions.assertTrue(authorities.contains("ROLE_ADMIN"));
        Assertions.assertTrue(authorities.contains("ROLE_USER"));
    }
}
