package com.example.AutoWorkShop.web;

import com.example.AutoWorkShop.domain.binding.RepairAddBindingModel;
import com.example.AutoWorkShop.domain.binding.RepairDetailsAddBindingModel;
import com.example.AutoWorkShop.domain.entities.ClientEntity;
import com.example.AutoWorkShop.domain.entities.RepairDetail;
import com.example.AutoWorkShop.domain.entities.enums.ClassificationEnum;
import com.example.AutoWorkShop.domain.service.RepairAddServiceModel;
import com.example.AutoWorkShop.service.AutoPartService;
import com.example.AutoWorkShop.service.CarService;
import com.example.AutoWorkShop.service.RepairDetailService;
import com.example.AutoWorkShop.service.RepairService;
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
import java.util.Set;

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

    @GetMapping("/add/{id}")
    public String addRepairCar(@PathVariable Long id, Model model) {

        model.addAttribute("car", carService.findCarById(id));
        model.addAttribute("classificationEnum", ClassificationEnum.values());
        return "repair-add-id";
    }

//    @PostMapping("/add/{id}")
//    public String addRepairCarByIdSuccessfully(@PathVariable Long id,
//                                               @Valid RepairAddBindingModel repairAddBindingModel,
//                                               BindingResult bindingResult,
//                                               RedirectAttributes redirectAttributes,
//                                               @AuthenticationPrincipal UserDetails principal) {
//
//
//
//        if (bindingResult.hasErrors()) {
//            redirectAttributes.addFlashAttribute("repairAddBindingModel", repairAddBindingModel);
//            redirectAttributes.addFlashAttribute(
//                    "org.springframework.validation.BindingResult.repairAddBindingModel", bindingResult);
//            return "redirect:/repairs/add/" + id;
//        }
//
//        RepairAddServiceModel newRepair = modelMapper
//                .map(repairAddBindingModel, RepairAddServiceModel.class);
//        String username = principal.getUsername();
//        newRepair.setUserEntity(username);
//
//        Long newId = repairService.inputRepair(newRepair);
//
//
//        return "redirct:/repairs/car/details/all/" + id;
//    }

    @GetMapping("/repair/car/{id}")
    public String viewCarRepair(@PathVariable Long id, Model model) {
        RepairViewModel repairViewModel = repairService.findById(id);
        model.addAttribute("car", repairViewModel.getCar());
        model.addAttribute("repair", repairService.findById(id));
        ClientEntity client = repairViewModel.getCar().getClient();
        if (client ==null) {
            model.addAttribute("notClient", true);
        }
        Set<RepairDetail> repairDetails = repairService.findById(id).getRepairDetails();

        model.addAttribute("repairDetails", repairDetails);

        return "repair-view";
    }

    @GetMapping("/car/details/all/{id}")
    public String viewAllCarRepairs(@PathVariable Long id, Model model) {
        CarViewModelWithRepairs carViewModelWithRepairs = carService.findCarWithRepairsById(id);
        if (carViewModelWithRepairs.getRepairs().isEmpty()) {
            model.addAttribute("notRepair", true);
        }
        ClientEntity clientEntity = carViewModelWithRepairs.getClientEntity();
        if (clientEntity == null) {
            model.addAttribute("notClient", true);
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
