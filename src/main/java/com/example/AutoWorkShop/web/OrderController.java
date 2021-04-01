package com.example.AutoWorkShop.web;

import com.example.AutoWorkShop.domain.binding.OrderAddBindingModel;
import com.example.AutoWorkShop.domain.entities.enums.ClassificationEnum;
import com.example.AutoWorkShop.domain.service.OrderAddServiceModel;
import com.example.AutoWorkShop.service.CarService;
import com.example.AutoWorkShop.service.OrderService;
import com.example.AutoWorkShop.view.OrderViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final ModelMapper modelMapper;
    private final OrderService orderService;
    private final CarService carService;

    public OrderController(ModelMapper modelMapper, OrderService orderService, CarService carService) {
        this.modelMapper = modelMapper;
        this.orderService = orderService;
        this.carService = carService;
    }


    @ModelAttribute("orderAddBindingModel")
    public OrderAddBindingModel orderAddBindingModel() {
        return new OrderAddBindingModel();
    }

    @GetMapping("/add")
    public String addOrder(Model model){
        model.addAttribute("cars", carService.findAllCars());
        model.addAttribute("classificationEnum", ClassificationEnum.values());
        return "order-add";
    }

    @PostMapping("/add")
    public String addOrderSuccessfully(@Valid OrderAddBindingModel orderAddBindingModel,
                                       BindingResult bindingResult,
                                       RedirectAttributes redirectAttributes,
                                       @AuthenticationPrincipal UserDetails principal){
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("orderAddBindingModel", orderAddBindingModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.orderAddBindingModel", bindingResult);

            return "redirect:add";
        }

        OrderAddServiceModel orderAddServiceModel = modelMapper
                .map(orderAddBindingModel, OrderAddServiceModel.class);
        String username = principal.getUsername();
        orderAddServiceModel.setUserEntity(username);
        orderService.inputOrder(orderAddServiceModel);
        System.out.println();
        return "redirect:/orders/search/user";
    }

    @GetMapping("/search")
    public String viewAll(Model model, Principal principal) {
//        String username = principal.getName();
//        List<OrderViewModel> userOrders = orderService.findAllOrdersByUsername(username);
        model.addAttribute("order", orderService.findAllOrdersView());
//        model.addAttribute("allUserOrders", userOrders);
        return "order-view";
    }

    @GetMapping("/search/{id}")
    public String viewById(Model model, @PathVariable Long id) {
        model.addAttribute("order", orderService.findById(id));
        return "order-view";
    }

    @GetMapping("/update/{id}")
    public String updateById(@PathVariable Long id) {
        orderService.updateById(id);
        return "redirect:/orders/search";
    }

    @GetMapping("/search/user")
    public String viewByUser(Model model, Principal principal) {
        String username = principal.getName();
        List<OrderViewModel> userOrders = orderService.findAllOrdersByUsername(username);
        model.addAttribute("order", userOrders);
        return "order-view";
    }
}
