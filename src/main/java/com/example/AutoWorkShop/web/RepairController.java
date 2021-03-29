package com.example.AutoWorkShop.web;

import com.example.AutoWorkShop.domain.binding.RepairAddBindingModel;
import com.example.AutoWorkShop.domain.service.RepairAddServiceModel;
import com.example.AutoWorkShop.service.CarService;
import com.example.AutoWorkShop.service.RepairService;
import com.example.AutoWorkShop.view.RepairViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/repairs")
public class RepairController {

    private final ModelMapper modelMapper;
    private final CarService carService;
    private final RepairService repairService;

    public RepairController(ModelMapper modelMapper,
                            CarService carService,
                            RepairService repairService) {
        this.modelMapper = modelMapper;
        this.carService = carService;
        this.repairService = repairService;
    }

    @ModelAttribute("repairAddBindingModel")
    public RepairAddBindingModel repairAddBindingModel() {
        return new RepairAddBindingModel();
    }

    @GetMapping("/add")
    public String addRepair(Model model) {
        model.addAttribute("cars", carService.findAllCars());
        return "repair-add";
    }

    @PostMapping("/add")
    public String addRepairSuccessfully(@Valid RepairAddBindingModel repairAddBindingModel,
                                        BindingResult bindingResult,
                                        RedirectAttributes redirectAttributes,
                                        @AuthenticationPrincipal UserDetails principal) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("repairAddBindingModel", repairAddBindingModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.repairAddBindingModel", bindingResult);
            return "redirect:add";
        }
        RepairAddServiceModel newRepair = modelMapper
                .map(repairAddBindingModel, RepairAddServiceModel.class);
        String username = principal.getUsername();
        newRepair.setUserEntity(username);

        Long newId = repairService.inputRepair(newRepair);
        System.out.println();
        return "redirect:/repairs/car/" + newId;
    }

    @GetMapping("/car/{id}")
    public String viewCarRepair(@PathVariable Long id, Model model) {
        RepairViewModel repairViewModel = repairService.findById(id);
        model.addAttribute("car", repairViewModel.getCar());
        model.addAttribute("repair", repairService.findById(id));
        return "repair-view";
    }
}
