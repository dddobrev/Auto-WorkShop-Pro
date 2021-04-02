package com.example.AutoWorkShop.service.impl;

import com.example.AutoWorkShop.domain.entities.UserEntity;
import com.example.AutoWorkShop.domain.entities.UserRoleEntity;
import com.example.AutoWorkShop.domain.entities.enums.UserRoleEnum;
import com.example.AutoWorkShop.domain.service.UserEditServiceModel;
import com.example.AutoWorkShop.domain.service.UserRegistrationServiceModel;
import com.example.AutoWorkShop.repository.UserRepository;
import com.example.AutoWorkShop.repository.UserRoleRepository;
import com.example.AutoWorkShop.service.UserService;
import com.example.AutoWorkShop.view.UserViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final AutoWorkShopUserService autoWorkShopUserService;

    public UserServiceImpl(UserRoleRepository userRoleRepository,
                           UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           ModelMapper modelMapper,
                           AutoWorkShopUserService autoWorkShopUserService) {
        this.userRoleRepository = userRoleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
        this.autoWorkShopUserService = autoWorkShopUserService;
    }

    @Override
    public void seedUsers() {
        if (userRepository.count() == 0) {

            UserRoleEntity adminRole = new UserRoleEntity().setRole(UserRoleEnum.ADMIN);
            UserRoleEntity userRole = new UserRoleEntity().setRole(UserRoleEnum.USER);

            userRoleRepository.saveAll(List.of(adminRole, userRole));

            UserEntity admin = new UserEntity()
                    .setUsername("admin")
                    .setPassword(passwordEncoder.encode("topsecret"))
                    .setFirstName("Mitko")
                    .setLastName("Dobrev");
            UserEntity user = new UserEntity()
                    .setUsername("user")
                    .setPassword(passwordEncoder.encode("topsecret"))
                    .setFirstName("Dobrin")
                    .setLastName("Dobrev");
            admin.setUserRoles(List.of(adminRole, userRole));
            user.setUserRoles(List.of(userRole));

            userRepository.saveAll(List.of(admin, user));
        }
    }

    @Override
    public void registerAndLoginUser(UserRegistrationServiceModel serviceModel) {

        UserEntity newUser = modelMapper.map(serviceModel, UserEntity.class);
        newUser.setPassword(passwordEncoder.encode(serviceModel.getPassword()));

        UserRoleEntity userRole = userRoleRepository.
                findByRole(UserRoleEnum.USER).orElseThrow(
                () -> new IllegalStateException("USER role not found. Please seed the roles."));

        newUser.addRole(userRole);

        newUser = userRepository.save(newUser);

        UserDetails principal = autoWorkShopUserService.loadUserByUsername(newUser.getUsername());

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                principal,
                newUser.getPassword(),
                principal.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @Override
    public boolean userNameExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    @Override
    public List<String> getAllUsersNames() {
        return this.userRepository.getAllUsernames();
    }

    @Override
    public String findUserByUsername(String username) {
        UserEntity userEntity = userRepository.findByUsername(username).orElse(null);
        return userEntity.getUsername();
    }

    @Override
    public List<UserViewModel> findAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(uv -> modelMapper.map(uv, UserViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserViewModel findUserViewByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(uv -> modelMapper.map(uv, UserViewModel.class))
                .orElse(null);
    }

    @Override
    public void changeRole(String username, UserRoleEnum userRoleEnum) {
        UserEntity user = this.userRepository.findByUsername(username).orElse(null);
        List<UserRoleEntity> admin =
                List.of(userRoleRepository.findByRole(UserRoleEnum.ADMIN).orElse(null),
                        userRoleRepository.findByRole(UserRoleEnum.USER).orElse(null));
        List<UserRoleEntity> userRole =
                List.of(userRoleRepository.findByRole(UserRoleEnum.USER).orElse(null));
        if (user != null && !user.getUsername().equalsIgnoreCase("admin")) {
            if (user.getUserRoles().size() == 1 && userRoleEnum.equals(UserRoleEnum.ADMIN)) {
                user.getUserRoles().clear();
                user.setUserRoles(new ArrayList<>());
                user.getUserRoles().addAll(admin);
                userRepository.save(user);
            } else if (user.getUserRoles().size() == 2 && userRoleEnum.equals(UserRoleEnum.USER)) {
                user.getUserRoles().clear();
                user.setUserRoles(new ArrayList<>());
                user.getUserRoles().addAll(userRole);
                userRepository.save(user);
            }
        }
//        else {
//            throw new IllegalArgumentException("Please don't select admin user");
//        }
    }

    @Override
    public UserViewModel findById(Long id) {
        return userRepository.findById(id)
                .map(user-> modelMapper.map(user, UserViewModel.class))
                .orElse(null);
    }

    @Override
    public UserEntity findUserEntityByUsername(String username) {
        return userRepository
                .findByUsername(username)
                .orElse(null);
    }

    @Override
    public void updateUser(UserEditServiceModel userEditServiceModel) {
        UserEntity updatedUserEntity = userRepository
                .findById(userEditServiceModel.getId())
                .orElse(null);
        updatedUserEntity.setFirstName(userEditServiceModel.getFirstName())
                .setLastName(userEditServiceModel.getLastName())
                .setEmail(userEditServiceModel.getEmail());
        userRepository.save(updatedUserEntity);
    }
}
