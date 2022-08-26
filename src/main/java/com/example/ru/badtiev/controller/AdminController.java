package com.example.ru.badtiev.controller;

import com.example.ru.badtiev.model.User;
import com.example.ru.badtiev.service.RoleService;
import com.example.ru.badtiev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @GetMapping("/admin")
    public String findAll(Model model,Principal principal){
        model.addAttribute("admin", userService.findByEmail(principal.getName()));
        model.addAttribute("users", userService.findAll());
        model.addAttribute("roles", roleService.listRoles());
        model.addAttribute("newUser", new User());
        return "/admin";
    }



    @PostMapping("/admin/create")
    public String createUser(@ModelAttribute("user") User user,
                             BindingResult bindingResult){
        if (bindingResult.hasErrors()) { return "/admin/create"; }
        else {
            userService.saveUser(user);
        }
        return "redirect:/admin";
    }

    @DeleteMapping("/admin/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteById(id);
        return "redirect:/admin";
    }



    @PostMapping("/admin/update/{id}")
    public String updateUser(@ModelAttribute("user") User user,@RequestParam(value = "role") String role, BindingResult bindingResult){
        user.setRoles(roleService.findRolesByName(role));
        if (bindingResult.hasErrors()) { return "/admin/update/{id}"; }
        else userService.saveUser(user);
        return "redirect:/admin";
    }
}
