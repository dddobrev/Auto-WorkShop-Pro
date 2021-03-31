package com.example.AutoWorkShop.web;

import com.example.AutoWorkShop.domain.binding.RepairAddBindingModel;
import com.example.AutoWorkShop.domain.binding.RepairDetailsAddBindingModel;
import com.example.AutoWorkShop.domain.entities.RepairDetail;
import com.example.AutoWorkShop.domain.service.RepairAddServiceModel;
import com.example.AutoWorkShop.service.AutoPartService;
import com.example.AutoWorkShop.service.CarService;
import com.example.AutoWorkShop.service.RepairDetailService;
import com.example.AutoWorkShop.service.RepairService;
import com.example.AutoWorkShop.view.CarViewModel;
import com.example.AutoWorkShop.view.CarViewModelWithRepairs;
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
import java.util.List;

@Controller
@RequestMapping("/repairs")
public class RepairController {

    private final ModelMapper modelMapper;
    private final CarService carService;
    private final RepairService repairService;
    private final RepairDetailService repairDetailService;
    private final AutoPartService autoPartService;

    public RepairController(ModelMapper modelMapper,
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
        return "redirect:/repairs/repair/car/" + newId;
    }

    @GetMapping("/repair/car/{id}")
    public String viewCarRepair(@PathVariable Long id, Model model) {
        RepairViewModel repairViewModel = repairService.findById(id);
        model.addAttribute("car", repairViewModel.getCar());
        model.addAttribute("repair", repairService.findById(id));
        if (repairViewModel.getRepairDetails().isEmpty()) {
            model.addAttribute("notRepair", false);
        }

        List<RepairDetail> repairDetails = repairViewModel.getRepairDetails();
        System.out.println();
        model.addAttribute("repairDetails", repairDetails);

        return "repair-view";
    }

    @GetMapping("/car/details/all/{id}")
    public String viewAllCarRepairs(@PathVariable Long id, Model model) {
        CarViewModelWithRepairs carViewModelWithRepairs = carService.findCarWithRepairsById(id);
        if (carViewModelWithRepairs.getRepairs().isEmpty()) {
            model.addAttribute("notRepair", true);
        }
        model.addAttribute("car", carViewModelWithRepairs);
        model.addAttribute("repairs", carViewModelWithRepairs.getRepairs());
        return "repair-view-all";
    }

    @GetMapping("/repair/car/details/add/")
    public String viewRepairDetailsAdd(@PathVariable Long id, Model model) {
        RepairViewModel repairViewModelById = repairService.findById(id);
        model.addAttribute("parts", autoPartService.findAllAutoParts());
        model.addAttribute("repairDetailsAddBindingModel", new RepairDetailsAddBindingModel());
        return "repair-details-add";
    }
}
