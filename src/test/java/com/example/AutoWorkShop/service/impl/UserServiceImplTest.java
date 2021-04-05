package com.example.AutoWorkShop.service.impl;

import com.example.AutoWorkShop.domain.entities.UserEntity;
import com.example.AutoWorkShop.domain.entities.UserRoleEntity;
import com.example.AutoWorkShop.domain.entities.enums.UserRoleEnum;
import com.example.AutoWorkShop.repository.UserRepository;
import com.example.AutoWorkShop.repository.UserRoleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    UserServiceImpl serviceToTest;
    UserEntity mitko;
    UserEntity dido;
    UserRoleEntity admin;
    UserRoleEntity user;

    @Mock
    UserRoleRepository mockUserRoleRepository;
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
    void setUp() {
        admin = new UserRoleEntity();
        admin.setRole(UserRoleEnum.ADMIN);
        user = new UserRoleEntity();
        user.setRole(UserRoleEnum.USER);
        passwordEncoder = new BCryptPasswordEncoder();
        serviceToTest = new UserServiceImpl(mockUserRoleRepository, mockedUserRepository, passwordEncoder, modelMapper, userSecurity);
        mitko = new UserEntity();
        mitko.setUsername("mitko").setPassword(passwordEncoder.encode("123")).setEmail("m@m").setUserRoles(List.of(admin));
        dido = new UserEntity();
        dido.setUsername("dido").setPassword(passwordEncoder.encode("321")).setEmail("d@d").setUserRoles(List.of(user));

    }


    @Test
    void getAllUsers() {

        when(serviceToTest.getAllUsersNames()).thenReturn(List.of(mitko.getUsername(), dido.getUsername()));
        List<String> allFindUsers = serviceToTest.getAllUsersNames();
        assertEquals(allFindUsers.get(0), mitko.getUsername());
        assertEquals(allFindUsers.get(1), dido.getUsername());
    }

    @Test
    void userNameExistsTest() {

        Mockito.when(mockedUserRepository.findByUsername("mitko")).thenReturn(Optional.of(mitko));
        boolean current = serviceToTest.userNameExists("mitko");
        assertTrue(current);
    }

    @Test
    void userNameNotExistsTest() {
        Mockito.when(mockedUserRepository.findByUsername("mitko")).thenReturn(Optional.empty());
        boolean current = serviceToTest.userNameExists("mitko");
        assertFalse(current);
    }

}
