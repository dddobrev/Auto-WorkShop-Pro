package com.example.AutoWorkShop.service.impl;

import com.example.AutoWorkShop.domain.entities.UserEntity;
import com.example.AutoWorkShop.domain.entities.UserRoleEntity;
import com.example.AutoWorkShop.domain.entities.enums.UserRoleEnum;
import com.example.AutoWorkShop.repository.UserRepository;
import com.example.AutoWorkShop.repository.UserRoleRepository;
import com.example.AutoWorkShop.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@Transactional
public class UserServiceImplTest {
    UserService serviceToTest;
    UserEntity mitko;
    UserEntity dido;
    UserRoleEntity admin;
    UserRoleEntity user;

    @Mock
    UserRoleRepository userRoleRepository;
    @Mock
    UserRepository mockedUserRepository;
    @Mock
    PasswordEncoder passwordEncoder;
    @Mock
    ModelMapper modelMapper;

//    @Autowired
//    AutoWorkShopUserService userSecurity;

    @Mock
    AutoWorkShopUserService userSecurity;

    @BeforeEach
    public void setUp() {
        admin = new UserRoleEntity();
        admin.setRole(UserRoleEnum.ADMIN);
        user = new UserRoleEntity();
        user.setRole(UserRoleEnum.USER);
        passwordEncoder = new BCryptPasswordEncoder();
        serviceToTest = new UserServiceImpl(userRoleRepository, mockedUserRepository, passwordEncoder, modelMapper, userSecurity);
        mitko = new UserEntity();
        mitko.setUsername("mitko").setPassword("123").setEmail("m@m").setUserRoles(List.of(admin));
        dido = new UserEntity();
        dido.setUsername("dido").setPassword("321").setEmail("d@d").setUserRoles(List.of(user));

    }

//
//    @Test
//    void getAllUsers() {
//        Mockito.when(mockedUserRepository.findAll()).thenReturn(List.of(mitko, dido));
//        List<String> allFindUsers = serviceToTest.getAllUsersNames();
//        assertEquals(allFindUsers.get(0), dido.getUsername());
//        assertEquals(allFindUsers.get(1), mitko.getUsername());
//    }
}
