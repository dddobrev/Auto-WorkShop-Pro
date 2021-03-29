package com.example.AutoWorkShop.web;

import com.example.AutoWorkShop.service.CarouselService;
import com.example.AutoWorkShop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;


@Controller
public class HomeController {
    private final CarouselService carouselService;

    public HomeController(CarouselService carouselService) {

        this.carouselService = carouselService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("firstImg", carouselService.firstImage());
        model.addAttribute("secondImg", carouselService.secondImage());
        model.addAttribute("thirdImg", carouselService.thirdImage());
        return "home";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("firstImg", carouselService.firstImage());
        model.addAttribute("secondImg", carouselService.secondImage());
        model.addAttribute("thirdImg", carouselService.thirdImage());
        return "index";
    }
}
