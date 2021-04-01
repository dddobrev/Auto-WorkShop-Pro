package com.example.AutoWorkShop.web;

import com.example.AutoWorkShop.domain.binding.ManufactureAddBindingModel;
import com.example.AutoWorkShop.domain.service.ManufacturerAddServiceModel;
import com.example.AutoWorkShop.service.ManufacturerService;
import com.example.AutoWorkShop.view.ManufactureViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

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
    public String addManufactureSuccessful(@Valid ManufactureAddBindingModel manufactureAddBindingModel,
                                           BindingResult bindingResult,
                                           RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("manufactureAddBindingModel", manufactureAddBindingModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.manufactureAddBindingModel", bindingResult);

            return "redirect:/manufacturers/add";
        }

        ManufacturerAddServiceModel newManufacture = modelMapper
                .map(manufactureAddBindingModel, ManufacturerAddServiceModel.class);

        Long newId = manufacturerService.inputManufactures(newManufacture);

        return "redirect:/manufacturers/search/" + newId;
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

    @GetMapping("/search/{id}")
    public String searchManufacturesGetById(@PathVariable Long id, Model model) {
        model.addAttribute("manufacturer", manufacturerService.findManufacturerId(id));
        return "manufacture-view";
    }
    @GetMapping("/edit/{id}")
    public String editManufacturesGetById(@PathVariable Long id, Model model) {
        model.addAttribute( "manufacturer", manufacturerService.findManufacturerId(id));
        return "manufacture-edit";
    }

    @PatchMapping("/edit/{id}")
    public String editManufacturer(@PathVariable Long id,
                                   @Valid ManufactureAddBindingModel manufactureAddBindingModel,
                                   BindingResult bindingResult,
                                   RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("manufactureAddBindingModel", manufactureAddBindingModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.manufactureAddBindingModel", bindingResult);

            return "redirect:edit/{id}";
        }
        ManufacturerAddServiceModel newManufacture = modelMapper
                .map(manufactureAddBindingModel, ManufacturerAddServiceModel.class);
        manufacturerService.updateManufactures(newManufacture);

        return "redirect:/manufacturers/search/" +id;
    }
}
