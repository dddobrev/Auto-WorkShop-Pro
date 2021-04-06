package com.example.AutoWorkShop.service.impl;

import com.example.AutoWorkShop.domain.entities.ClientEntity;
import com.example.AutoWorkShop.repository.ClientRepository;
import com.example.AutoWorkShop.view.ClientViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientServiceImplTest {

    private ClientServiceImpl serviceToTest;
    private ClientEntity mitko, mitko2, kiro;


    @Mock
    ClientRepository mockClientRepository;
    @Autowired
    ModelMapper modelMapper;


    @BeforeEach
    void setUp() {
        modelMapper = new ModelMapper();
        serviceToTest = new ClientServiceImpl(mockClientRepository, modelMapper);
        mitko = new ClientEntity();
        mitko.setFirstName("Mitko").setSecondName("Dobrev").setTelephone("0888111111");
        mitko2 = new ClientEntity();
        mitko2.setFirstName("Mitko").setSecondName("Nikolov").setTelephone("0888333333");
        kiro = new ClientEntity();
        kiro.setFirstName("Kiro").setSecondName("Kirov").setTelephone("0888222222");


    }

    @Test
    void findAllClients() {
        when(mockClientRepository.findAll()).thenReturn(List.of(mitko, kiro));
        List<ClientViewModel> output = serviceToTest
                .findAll()
                .stream()
                .map(cl -> modelMapper.map(cl, ClientViewModel.class))
                .collect(Collectors.toList());
        assertEquals(mitko.getFirstName(), output.get(0).getFirstName());
        assertEquals(kiro.getFirstName(), output.get(1).getFirstName());
    }

    @Test
    void findClientByFirstName() {
        when(mockClientRepository.findAllByFirstName(contains("Mitko"))).thenReturn(List.of(mitko, mitko2));
        List<ClientViewModel> output = serviceToTest
                .findClientByFirstName("Mitko")
                .stream()
                .map(cl -> modelMapper.map(cl, ClientViewModel.class))
                .collect(Collectors.toList());
        assertEquals(mitko.getFirstName(), output.get(0).getFirstName());
        assertEquals(mitko2.getFirstName(), output.get(1).getFirstName());
    }

    @Test
    void findClientBySecondName() {
        when(mockClientRepository.findAllBySecondName(contains("Dobrev"))).thenReturn(List.of(mitko));
        List<ClientViewModel> output = serviceToTest
                .findClientBySecondName("Dobrev")
                .stream()
                .map(cl -> modelMapper.map(cl, ClientViewModel.class))
                .collect(Collectors.toList());
        assertEquals(mitko.getSecondName(), output.get(0).getSecondName());
    }

    @Test
    void findClientByTelephone() {
        when(mockClientRepository.findAllByTelephone(contains("0888222222"))).thenReturn(List.of(kiro));
        List<ClientViewModel> output = serviceToTest
                .findClientByTelephone("0888222222")
                .stream()
                .map(cl -> modelMapper.map(cl, ClientViewModel.class))
                .collect(Collectors.toList());
        assertEquals(kiro.getTelephone(), output.get(0).getTelephone());
    }

    @Test
    void findClientByTelephoneNumberNotFound() {
        when(mockClientRepository.findAllByTelephone(contains("0888222233"))).thenThrow(NullPointerException.class);
        assertThrows(NullPointerException.class, ()-> assertNull(serviceToTest.findClientByTelephone("0888222233")));
    }
}