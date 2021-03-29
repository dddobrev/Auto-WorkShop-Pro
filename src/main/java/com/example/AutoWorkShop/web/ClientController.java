package com.example.AutoWorkShop.web;

import com.example.AutoWorkShop.domain.binding.ClientAddBindingModel;
import com.example.AutoWorkShop.domain.service.ClientAddServiceModel;
import com.example.AutoWorkShop.service.ClientService;
import com.example.AutoWorkShop.view.ClientViewModel;
import org.dom4j.rule.Mode;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/clients")
public class ClientController {
    private final ModelMapper modelMapper;
    private final ClientService clientService;

    public ClientController(ModelMapper modelMapper, ClientService clientService) {
        this.modelMapper = modelMapper;
        this.clientService = clientService;
    }

    @ModelAttribute("clientAddBindingModel")
    public ClientAddBindingModel createClientModel() {
        return new ClientAddBindingModel();
    }

    @GetMapping("/add")
    public String addClient() {
        return "client-add";
    }

    @GetMapping("/search")
    public String searchClient(Model model) {

        if (!model.containsAttribute("clientViewModel")) {
            model.addAttribute("clientViewModel", new ClientViewModel());
            model.addAttribute("notFound", false);
        }
        return "client-search";
    }

    @GetMapping("/view")
    public String clientView(Model model) {
        if (!model.containsAttribute("clientViewModel")) {
            model.addAttribute("clientViewModel", new ClientViewModel());
            model.addAttribute("notFound", false);
        }
        return "client-view";
    }

    @PostMapping("/add")
    public String addSuccessfullyClient(
            @Valid ClientAddBindingModel clientAddBindingModel,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("clientAddBindingModel", clientAddBindingModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.clientAddBindingModel", bindingResult);

            return "redirect:/clients/add";
        }
        ClientAddServiceModel newClient = modelMapper
                .map(clientAddBindingModel, ClientAddServiceModel.class);
        Long newId = clientService.inputClient(newClient);

        return "redirect:/clients/view/" + newId;
    }

    @PostMapping("/search")
    public String clientSearch(Model model,
                               String firstName,
                               String secondName,
                               String telephone) {

        List<ClientViewModel> findAllCl = new ArrayList<>();
        if (firstName.equals("".trim()) && secondName.equals("".trim()) && !telephone.equals("".trim())) {

            Object a = clientService.findClientByTelephone(telephone);
            if (a != null) {
                findAllCl.addAll(clientService.findClientByTelephone(telephone));
            }

            model.addAttribute("client", clientService.findClientByTelephone(telephone));


        } else if (secondName.equals("".trim()) && telephone.equals("".trim()) && !firstName.equals("".trim())) {
            findAllCl.addAll(clientService.findClientByFirstName(firstName));
            model.addAttribute("client", clientService.findClientByFirstName(firstName));
        } else if (firstName.equals("".trim()) && telephone.equals("".trim()) && !secondName.equals("".trim())) {
            clientService.findClientByFirstName(secondName);
            model.addAttribute("client", clientService.findClientBySecondName(secondName));
        }
        if (findAllCl.isEmpty()) {
            model.addAttribute("notFound", true);
        }
        return "client-view";
    }

    @GetMapping("/edit/{id}")
    public String updateClient(@PathVariable Long id, Model model) {

        model.addAttribute("client", clientService.findClientById(id));

        return "client-edit";
    }

    @GetMapping("/view/{id}")
    public String viewClient(@PathVariable Long id, Model model) {
        model.addAttribute("client", clientService.findClientById(id));
        return "client-view";
    }

    @PatchMapping("/edit/{id}")
    public String updatePatch(@PathVariable Long id,
                              @Valid ClientAddBindingModel clientAddBindingModel,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("clientAddBindingModel", clientAddBindingModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.clientAddBindingModel", bindingResult);

            return "redirect:edit/{id}";
        }

        ClientAddServiceModel newClient = modelMapper
                .map(clientAddBindingModel, ClientAddServiceModel.class);
        clientService.updateClient(newClient);
        return "redirect:/clients/view/{id}";
    }
}
