package com.example.AutoWorkShop.web;

import com.example.AutoWorkShop.domain.binding.UserEditBindingModel;
import com.example.AutoWorkShop.domain.binding.UserRegistrationBindingModel;
import com.example.AutoWorkShop.domain.entities.UserEntity;
import com.example.AutoWorkShop.domain.service.UserEditServiceModel;
import com.example.AutoWorkShop.domain.service.UserRegistrationServiceModel;
import com.example.AutoWorkShop.service.UserService;
import com.example.AutoWorkShop.view.UserViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.function.Predicate;

@Controller
@RequestMapping("/users")
public class UserController {

    private final ModelMapper modelMapper;
    private final UserService userService;

    public UserController(ModelMapper modelMapper, UserService userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @ModelAttribute("registrationBindingModel")
    public UserRegistrationBindingModel createBindingModel() {
        return new UserRegistrationBindingModel();
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerAndLoginUser(
            @Valid UserRegistrationBindingModel registrationBindingModel,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("registrationBindingModel", registrationBindingModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.registrationBindingModel", bindingResult);

            return "redirect:/users/register";
        }

        if (userService.userNameExists(registrationBindingModel.getUsername())) {
            redirectAttributes.addFlashAttribute("registrationBindingModel", registrationBindingModel);
            redirectAttributes.addFlashAttribute("userExistsError", true);

            return "redirect:/users/register";
        }

        UserRegistrationServiceModel userServiceModel = modelMapper.map(registrationBindingModel,
                UserRegistrationServiceModel.class);
        userService.registerAndLoginUser(userServiceModel);

        return "redirect:/home";
    }

    @PostMapping("/login-error")
    public ModelAndView failedLogin(@ModelAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY)
                                            String username,
                                    RedirectAttributes attributes) {
        ModelAndView modelAndView = new ModelAndView();

        attributes.addFlashAttribute("bad_credentials", true);
        attributes.addFlashAttribute("username", username);
        modelAndView.setViewName("redirect:/users/login");
        return modelAndView;
    }

    @GetMapping("/view")
    public String viewUser(Model model, @AuthenticationPrincipal Principal principal) {
        String username = principal.getName();
        UserEntity userEntity = userService.findUserEntityByUsername(username);
        UserViewModel userViewModel = userService.findUserViewByUsername(username);
        model.addAttribute("userView", userViewModel);
        model.addAttribute("id", userEntity.getId());
        return "user-view";
    }

//    @GetMapping("/view/{username}")
//    public String viewUserByUsername(Model model, @AuthenticationPrincipal Principal principal,
//                                     @PathVariable String username) {
//        username = principal.getName();
////        UserEntity userEntity = userService.findUserEntityByUsername(username);
//        UserViewModel userViewModel = userService.findUserViewByUsername(username);
//        model.addAttribute("userView", userViewModel);
////        model.addAttribute("id", userEntity.getId());
//        return "user-view";
//    }

    @GetMapping("/edit/{id}")
    public String editUser(Model model,
                           @AuthenticationPrincipal Principal principal,
                           @PathVariable Long id) {
        String username = principal.getName();
        UserViewModel byId = userService.findById(id);
        UserViewModel userViewModel = userService.findUserViewByUsername(username);
        if (byId.getUsername().equals(username)) {
            model.addAttribute("userEditBindingModel", new UserEditBindingModel());
            model.addAttribute("userView", userViewModel);
            model.addAttribute("id", id);
        } else {
            model.addAttribute("notAuthorize", true);
        }
        return "user-edit";
    }

    @PatchMapping("/edit/{id}")
    public String editUser(@PathVariable Long id,
                           @Valid UserEditBindingModel userEditBindingModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes,
                           @AuthenticationPrincipal Principal principal) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("clientAddBindingModel", userEditBindingModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.userEditBindingModel", bindingResult);
            return "redirect:/users/edit/{id}";
        }
        UserEditServiceModel userEditServiceModel = modelMapper
                .map(userEditBindingModel, UserEditServiceModel.class);
        userService.updateUser(userEditServiceModel);

        return "redirect:/users/view";
    }
}
