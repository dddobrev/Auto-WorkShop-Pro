package com.example.AutoWorkShop.web;

import com.example.AutoWorkShop.domain.entities.ManufacturerEntity;
import com.example.AutoWorkShop.service.ManufacturerService;
import com.example.AutoWorkShop.view.ClientViewModel;
import com.example.AutoWorkShop.view.ManufactureViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manufacturers")
public class ManufactureController {
    private final ModelMapper modelMapper;
    private final ManufacturerService manufacturerService;

    public ManufactureController(ModelMapper modelMapper, ManufacturerService manufacturerService) {
        this.modelMapper = modelMapper;
        this.manufacturerService = manufacturerService;
    }

    @ModelAttribute("manufactureViewModel")
    public ManufactureViewModel manufactureViewModel() {
        return new ManufactureViewModel();
    }

    @GetMapping("/add")
    public String addManufacture() {
        return "manufacture-add";
    }

    @PostMapping("/add")
    public String addManufactureSuccessful(Model model, String manufacturerName) {

        if (manufacturerName.trim().isBlank()) {
            model.addAttribute("noSuccess", true);
            return "redirect:/manufacturers/add";
        }
        //todo make save with view model
        ManufacturerEntity manufacturerEntity = new ManufacturerEntity();
        manufacturerEntity.setManufacturerName(manufacturerName);
        manufacturerService.inputManufactures(manufacturerEntity);

        return "redirect:/manufacturers/search";
    }

    @GetMapping("/search")
    public String searchManufacturesGet() {

        return "manufacture-search";
    }

    @PostMapping("/search")
    public String searchManufacture(Model model,
                                    String manufacturerName) {
        if (!manufacturerName.equals("".trim())) {
            Object a = manufacturerService.findManufacturerByName(manufacturerName);
            if (a == null) {
                model.addAttribute("notFound", true);
            } else {
                model.addAttribute("manufacturer", manufacturerService.findManufacturerByName(manufacturerName));
            }
        }
        return "manufacture-view";
    }
}
