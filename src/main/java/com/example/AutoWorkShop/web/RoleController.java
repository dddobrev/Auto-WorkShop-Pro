package com.example.AutoWorkShop.web;

import com.example.AutoWorkShop.domain.entities.enums.UserRoleEnum;
import com.example.AutoWorkShop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/role")
public class RoleController {
    private final UserService userService;

    public RoleController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("names", this.userService.findAllUsers());
        return "role-add";
    }

    @PostMapping("/add")
    public String addConfirm(String username, String role) {

//        String userByUsername = userService.findUserByUsername(username);
//        System.out.println();
        this.userService.changeRole(username, UserRoleEnum.valueOf(role.toUpperCase()));
        return "redirect:/role/add";
    }

}
