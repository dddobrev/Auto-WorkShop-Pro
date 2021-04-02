package com.example.AutoWorkShop.web;

import com.example.AutoWorkShop.service.ClientService;
import com.example.AutoWorkShop.view.ClientViewModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/clients")
@RestController
public class ClientRestController {

    private final ClientService clientService;

    public ClientRestController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/search/phone")
    public List<ClientViewModel> clientViewModel(String phone) {
        List<ClientViewModel> clientByTelephoneNumber = clientService.findClientByTelephone(phone);
        return clientByTelephoneNumber;
    }

    @GetMapping("/search/all/api")
    public List<ClientViewModel> getAll() {
        return clientService.findAll();
    }

//    @PostMapping("/create")
//    public ResponseEntity<ClientAddServiceModel> create(
//            @RequestBody ClientAddServiceModel clientAddServiceModel,
//            UriComponentsBuilder uriComponentsBuilder) {
//        ClientViewModel clientViewModel = clientService.inputClientAndView(clientAddServiceModel);
//
//        return ResponseEntity.created(
//                uriComponentsBuilder
//                        .path("/clients/{id}")
//                        .buildAndExpand(clientViewModel.getId())
//                        .toUri()
//        ).build();
//
//    }

    @GetMapping("/search/{id}")
    public ClientViewModel getById(@PathVariable Long id) {
        return clientService.findClientById(id);
    }

}
