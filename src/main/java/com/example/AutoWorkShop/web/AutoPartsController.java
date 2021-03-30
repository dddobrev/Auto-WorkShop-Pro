package com.example.AutoWorkShop.web;

import com.example.AutoWorkShop.domain.binding.AutoPartBindingModel;
import com.example.AutoWorkShop.domain.binding.ClientAddBindingModel;
import com.example.AutoWorkShop.domain.service.AutoPartServiceModel;
import com.example.AutoWorkShop.domain.service.ClientAddServiceModel;
import com.example.AutoWorkShop.service.AutoPartService;
import com.example.AutoWorkShop.service.ManufacturerService;
import com.example.AutoWorkShop.service.SupplierService;
import com.example.AutoWorkShop.view.AutoPartsViewModel;
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
@RequestMapping("/parts")
public class AutoPartsController {
    private final AutoPartService autoPartService;
    private final ManufacturerService manufacturerService;
    private final SupplierService supplierService;
    private final ModelMapper modelMapper;

    public AutoPartsController(AutoPartService autoPartService, ManufacturerService manufacturerService, SupplierService supplierService, ModelMapper modelMapper) {
        this.autoPartService = autoPartService;
        this.manufacturerService = manufacturerService;
        this.supplierService = supplierService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute("autoPartBindingModel")
    public AutoPartBindingModel autoPartBindingModel() {
        return new AutoPartBindingModel();
    }

    @GetMapping("/add")
    public String addParts(Model model) {
        model.addAttribute("manufacturer", manufacturerService.findAll());
        model.addAttribute("supplier", supplierService.findAll());
        return "part-add";
    }

    @PostMapping("/add")
    public String addPartSuccessfullyPart(@Valid AutoPartBindingModel autoPartBindingModel,
                                          BindingResult bindingResult,
                                          RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("autoPartBindingModel", autoPartBindingModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.autoPartBindingModel", bindingResult);
            return "redirect:/parts/add";
        }
        if (!autoPartService.partExist(autoPartBindingModel.getPartNumber())) {
            redirectAttributes.addFlashAttribute("autoPartBindingModel", autoPartBindingModel);
            redirectAttributes.addFlashAttribute("partExist", true);
            return "redirect:/parts/add";
        }

        AutoPartServiceModel autoPartServiceModel = modelMapper
                .map(autoPartBindingModel, AutoPartServiceModel.class);
        autoPartService.inputParts(autoPartServiceModel);

        return "redirect:/parts/search";
    }

    @GetMapping("/search")
    public String searchParts(Model model) {
        model.addAttribute("partViewModel", new AutoPartsViewModel());
        return "part-search";
    }

    @PostMapping("/search")
    public String searchPartPost(Model model, String partNumber, String partOeNumber) {


        if (!partNumber.isBlank() && partOeNumber.isBlank()) {
            if (autoPartService.findAutoPartByNumber(partNumber).getPartOeNumber().isEmpty()) {
                model.addAttribute("notOEN", true);
            }
            AutoPartsViewModel autoPartByNumber = autoPartService.findAutoPartByNumber(partNumber);
            if (autoPartByNumber != null) {
                model.addAttribute("parts", autoPartByNumber);
                model.addAttribute("notFound", false);
            }
        } else if (partNumber.isBlank() && !partOeNumber.isBlank()) {
            if (autoPartService.findAutoPartByOeNumber(partOeNumber).isEmpty()) {
                model.addAttribute("notOEN", true);
            }
            model.addAttribute("parts", autoPartService.findAutoPartByOeNumber(partOeNumber));
        } else if (partNumber.isBlank() && partOeNumber.isBlank()) {
            model.addAttribute("emptyFeeds", true);
        }

        return "part-view";
    }

    @GetMapping("/view/{id}")
    public String partView(@PathVariable Long id, Model model) {
        model.addAttribute("parts", autoPartService.findAutoPartById(id));
        return "part-view";
    }

    @GetMapping("/edit/{id}")
    public String updatePart(@PathVariable Long id, Model model) {
        model.addAttribute("parts", autoPartService.findAutoPartById(id));
        model.addAttribute("manufacturer", manufacturerService.findAll());
        model.addAttribute("supplier", supplierService.findAll());
        return "part-edit";
    }

    @PatchMapping("/edit/{id}")
    public String updatePartPach(@PathVariable Long id,
                                 @Valid AutoPartBindingModel autoPartBindingModel,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("autoPartBindingModel", autoPartBindingModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.clientAddBindingModel", bindingResult);

            return "redirect:edit/{id}";
        }
        AutoPartServiceModel editParts = modelMapper
                .map(autoPartBindingModel, AutoPartServiceModel.class);
        autoPartService.updateClient(editParts);
        return "redirect:/parts/view/{id}";
    }

}
