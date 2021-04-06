package com.example.AutoWorkShop.service.impl;

import com.example.AutoWorkShop.domain.entities.ClientEntity;
import com.example.AutoWorkShop.domain.service.ClientAddServiceModel;
import com.example.AutoWorkShop.repository.ClientRepository;
import com.example.AutoWorkShop.service.ClientService;
import com.example.AutoWorkShop.view.ClientViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ModelMapper modelMapper;

    public ClientServiceImpl(ClientRepository clientRepository,
                             ModelMapper modelMapper) {
        this.clientRepository = clientRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ClientViewModel> findAll() {
        return this.clientRepository.
                findAll()
                .stream()
                .map(client -> modelMapper.map(client, ClientViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientViewModel> findClientByFirstName(String firstName) {
        if (firstName.contains("*")) {
            String substring = firstName.substring(0, firstName.length() - 1);
            return this.clientRepository.
                    findAllByFirstNameContains(substring)
                    .stream()
                    .map(client -> modelMapper.map(client, ClientViewModel.class))
                    .collect(Collectors.toList());
        }
        return this.clientRepository.
                findAllByFirstName(firstName)
                .stream()
                .map(client -> modelMapper.map(client, ClientViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientViewModel> findClientBySecondName(String secondName) {
        return this.clientRepository.
                findAllBySecondName(secondName)
                .stream()
                .map(client -> modelMapper.map(client, ClientViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientViewModel> findClientByTelephone(String telephone) {
        List<ClientViewModel> collect = clientRepository
                .findAllByTelephone(telephone)
                .stream()
                .map(client -> modelMapper.map(client, ClientViewModel.class))
                .collect(Collectors.toList());
        if (collect.size() == 0) {
            return null;
        }
        return collect;
    }

//    @Override
//    public ClientViewModel findClientByTelephoneNumber(String telephone) {
//        return clientRepository
//                .findByTelephoneContains(telephone)
//                .map(cl -> modelMapper.map(cl, ClientViewModel.class))
//                .orElseThrow(IllegalArgumentException::new);
//
//    }

    @Override
    public ClientViewModel findClientById(Long id) {
        return clientRepository
                .findById(id)
                .map(cl -> modelMapper.map(cl, ClientViewModel.class))
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public Long inputClient(ClientAddServiceModel newClient) {
        ClientEntity clientEntity = modelMapper.map(newClient, ClientEntity.class);
        clientEntity.setFirstName(newClient.getFirstName().trim())
                .setSecondName(newClient.getSecondName().trim())
                .setTelephone(newClient.getTelephone().trim());
        clientRepository.save(clientEntity);

        return clientEntity.getId();
    }

    @Override
    public ClientViewModel inputClientAndView(ClientAddServiceModel newClient) {
        ClientEntity clientEntity = modelMapper.map(newClient, ClientEntity.class);
        clientEntity.setFirstName(newClient.getFirstName())
                .setSecondName(newClient.getSecondName())
                .setTelephone(newClient.getTelephone());
        clientRepository.save(clientEntity);

        ClientViewModel newClientViewModel = modelMapper.map(clientEntity, ClientViewModel.class);

        return newClientViewModel;
    }

    @Override
    public void updateClient(ClientAddServiceModel newClient) {
        ClientEntity clientEntity = clientRepository.findById(newClient.getId()).orElse(null);
        if (clientEntity !=null){
            clientEntity.setFirstName(newClient.getFirstName())
                    .setSecondName(newClient.getSecondName())
                    .setTelephone(newClient.getTelephone());
            clientRepository.save(clientEntity);
        }
    }
}
