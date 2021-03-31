package com.example.AutoWorkShop.web;

import com.example.AutoWorkShop.domain.binding.CarAddBindingModel;
import com.example.AutoWorkShop.domain.entities.enums.FuelEnum;
import com.example.AutoWorkShop.domain.entities.enums.TransmissionEnum;
import com.example.AutoWorkShop.domain.service.CarAddServiceModel;
import com.example.AutoWorkShop.service.CarService;
import com.example.AutoWorkShop.service.ClientService;
import com.example.AutoWorkShop.view.CarViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final ModelMapper modelMapper;
    private final CarService carService;
    private final ClientService clientService;

    public CarController(ModelMapper modelMapper, CarService carService, ClientService clientService) {
        this.modelMapper = modelMapper;
        this.carService = carService;
        this.clientService = clientService;
    }

    @ModelAttribute("carAddBindingModel")
    public CarAddBindingModel createCarModel() {
        return new CarAddBindingModel();
    }

    @GetMapping("/add")
    public String addCar(Model model) {
        model.addAttribute("clientEntity", clientService.findAll());
        model.addAttribute("transmission", TransmissionEnum.values());
        model.addAttribute("fuel", FuelEnum.values());
        return "car-add";
    }

    @PostMapping("/add")
    public String addSuccessfullyCar(
            @Valid CarAddBindingModel carAddBindingModel,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes,
            @AuthenticationPrincipal Principal principal) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("carAddBindingModel", carAddBindingModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.carAddBindingModel", bindingResult);

            return "redirect:/cars/add";
        }
        if (!carService.carExist(carAddBindingModel.getVin())) {
            redirectAttributes.addFlashAttribute("carAddBindingModel", carAddBindingModel);
            redirectAttributes.addFlashAttribute("carExist", true);
            return "redirect:/cars/add";
        }
        CarAddServiceModel carAddModel = modelMapper
                .map(carAddBindingModel, CarAddServiceModel.class);
        Long newCar = carService.inputCar(carAddModel, principal.getName());

        return "redirect:/cars/view/" + newCar;
    }

    @GetMapping("/search")
    public String searchCar(Model model) {
        if (!model.containsAttribute("carViewModel")) {
            model.addAttribute("carViewModel", new CarViewModel());
//            model.addAttribute("notFound", false);
        }
        return "car-search";
    }

    @PostMapping("/search")
    public String carSearch(Model modelMap,
                            String brand,
                            String model,
                            String coupeModel,
                            String engine,
                            String vin,
                            String regNumber) {
//find by brand and model
        if (!brand.equals("".trim()) && !model.equals("".trim()) &&
                coupeModel.equals("".trim()) && engine.equals("".trim())
                && vin.equals("".trim()) && regNumber.equals("".trim())) {
            if (carService.findCarByBrandAndModel(brand, model).isEmpty()) {
                modelMap.addAttribute("notFound", true);
            }
            modelMap.addAttribute("car", carService.findCarByBrandAndModel(brand, model));
//find by vin:
        } else if (brand.equals("".trim()) && model.equals("".trim()) &&
                coupeModel.equals("".trim()) && engine.equals("".trim())
                && !vin.equals("".trim()) && regNumber.equals("".trim())) {
            if (carService.findCarByVin(vin).isEmpty()) {
                modelMap.addAttribute("notFound", true);
            }
            modelMap.addAttribute("car", carService.findCarByVin(vin));
//find by reg.number:
        } else if (brand.equals("".trim()) && model.equals("".trim()) &&
                coupeModel.equals("".trim()) && engine.equals("".trim())
                && vin.equals("".trim()) && !regNumber.equals("".trim())) {
            if (carService.findCarByRegNumber(regNumber).isEmpty()) {
                modelMap.addAttribute("notFound", true);
            }
            modelMap.addAttribute("car", carService.findCarByRegNumber(regNumber));
//find by engine
        } else if (brand.equals("".trim()) && model.equals("".trim()) &&
                coupeModel.equals("".trim()) && !engine.equals("".trim())
                && vin.equals("".trim()) && regNumber.equals("".trim())) {
            if (carService.findAllByEngine(engine).isEmpty()) {
                modelMap.addAttribute("notFound", true);
            }
            modelMap.addAttribute("car", carService.findAllByEngine(engine));
//find by coupe model
        } else if (brand.equals("".trim()) && model.equals("".trim()) &&
                !coupeModel.equals("".trim()) && engine.equals("".trim())
                && vin.equals("".trim()) && regNumber.equals("".trim())) {
            if (carService.findCarByCoupeModel(coupeModel).isEmpty()) {
                modelMap.addAttribute("notFound", true);
            }
            modelMap.addAttribute("car", carService.findCarByCoupeModel(coupeModel));
        } else if (!brand.equals("".trim()) && model.isEmpty() &&
                coupeModel.isEmpty() && engine.isEmpty()
                && vin.isEmpty() && regNumber.isEmpty()) {
            List<CarViewModel> carByBrand = carService.findCarByBrand(brand);
            if (carService.findCarByBrand(brand).size() == 0) {
                modelMap.addAttribute("notFound", true);
            }
            modelMap.addAttribute("car", carService.findCarByBrand(brand));
        }

        return "car-view";
    }


    @GetMapping("/view/{id}")
    public String viewCar(@PathVariable Long id, Model model) {
        model.addAttribute("car", carService.findCarById(id));
        model.addAttribute("notClient", true);
        CarViewModel carById = carService.findCarById(id);
        if (carById.getClientEntity() == null) {
            model.addAttribute("notClient", false);
        }
        return "car-detail-view";
    }

    @GetMapping("/edit/{id}")
    public String editCar(@PathVariable Long id, Model model) {
        model.addAttribute("car", carService.findCarById(id));
        model.addAttribute("client", clientService.findAll());
        model.addAttribute("transmission", TransmissionEnum.values());
        model.addAttribute("fuel", FuelEnum.values());

        return "car-edit";
    }

    @PatchMapping("/edit/{id}")
    public String updatePatch(@PathVariable Long id,
                              @Valid CarAddBindingModel carAddBindingModel,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("clientAddBindingModel", carAddBindingModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.clientAddBindingModel", bindingResult);

            return "redirect:/cars/edit/" + id;
        }

        CarAddServiceModel updatedCar = modelMapper
                .map(carAddBindingModel, CarAddServiceModel.class);
        carService.updateClient(updatedCar);

        return "redirect:/cars/view/" + id;
    }

}
