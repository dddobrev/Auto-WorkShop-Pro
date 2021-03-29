package com.example.AutoWorkShop.web;

import com.example.AutoWorkShop.service.UserService;
import com.example.AutoWorkShop.view.UserViewModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;


@Controller
public class HomeController {
    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/home")
    public String home(Model model, Principal principal) {
//        UserViewModel userViewByUsername = userService.findUserViewByUsername(principal.getName());
//        model.addAttribute("userFirstName", userViewByUsername);
        return "index";
    }
}
