package com.example.AutoWorkShop.web;

import com.example.AutoWorkShop.domain.binding.RepairDetailsAddBindingModel;
import com.example.AutoWorkShop.domain.service.RepairDetailsAddServiceModel;
import com.example.AutoWorkShop.service.AutoPartService;
import com.example.AutoWorkShop.service.CarService;
import com.example.AutoWorkShop.service.RepairDetailService;
import com.example.AutoWorkShop.service.RepairService;
import com.example.AutoWorkShop.view.RepairViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/repairs")
public class RepairDetailsController {
    private final ModelMapper modelMapper;
    private final CarService carService;
    private final RepairService repairService;
    private final RepairDetailService repairDetailService;
    private final AutoPartService autoPartService;

    public RepairDetailsController(ModelMapper modelMapper,
                                   CarService carService,
                                   RepairService repairService,
                                   RepairDetailService repairDetailService,
                                   AutoPartService autoPartService) {
        this.modelMapper = modelMapper;
        this.carService = carService;
        this.repairService = repairService;
        this.repairDetailService = repairDetailService;
        this.autoPartService = autoPartService;
    }

    @ModelAttribute("repairDetailsAddBindingModel")
    public RepairDetailsAddBindingModel repairDetailsAddBindingModel() {
        return new RepairDetailsAddBindingModel();
    }

    @GetMapping("/repair/car/details/add/{id}")
    public String viewRepairDetails(@PathVariable Long id, Model model) {
        RepairViewModel repairViewModelById = repairService.findById(id);
        model.addAttribute("parts", autoPartService.findAllAutoParts());
        model.addAttribute("repair", repairViewModelById);
//        model.addAttribute("repairDetailsAddBindingModel", new RepairDetailsAddBindingModel());
        return "repair-details-add";
    }

    @PostMapping("/repair/car/details/add/{id}")
    public String addViewRepairDetailsSuccessfully(@PathVariable Long id,
                                                   @Valid RepairDetailsAddBindingModel repairDetailsAddBindingModel,
                                                   BindingResult bindingResult,
                                                   RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("repairDetailsAddBindingModel", repairDetailsAddBindingModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.repairDetailsAddBindingModel", bindingResult);
            return "redirect:/repairs/repair/car/details/add/" + id;
        }

        RepairDetailsAddServiceModel repairDetailsAddServiceModel = modelMapper
                .map(repairDetailsAddBindingModel, RepairDetailsAddServiceModel.class);
        Long newId = repairDetailService.inputRepairDetails(repairDetailsAddServiceModel, id);

        return "redirect:/repairs/repair/car/" + id;
    }
}
