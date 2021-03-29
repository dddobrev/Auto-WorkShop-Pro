package com.example.AutoWorkShop.service;

import com.example.AutoWorkShop.domain.service.ClientAddServiceModel;
import com.example.AutoWorkShop.view.ClientViewModel;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    List<ClientViewModel> findAll();

    List<ClientViewModel> findClientByFirstName(String firstName);

    List<ClientViewModel> findClientBySecondName(String secondName);

    List<ClientViewModel> findClientByTelephone(String telephone);

    ClientViewModel findClientByTelephoneNumber(String telephone);

    ClientViewModel findClientById(Long id);

    Long inputClient(ClientAddServiceModel newClient);

    ClientViewModel inputClientAndView(ClientAddServiceModel newClient);

    void updateClient(ClientAddServiceModel newClient);
}
