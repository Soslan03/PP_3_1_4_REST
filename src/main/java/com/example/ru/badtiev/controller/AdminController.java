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
    @GetMapping("/index")
    public String index(){

        return "index";
    }

    @GetMapping("/admin")
    public String findAll(Model model,Principal principal){
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        model.addAttribute("admin", userService.findByEmail(principal.getName()));
        return "user-list";
    }

    @GetMapping("/admin/user-create")
    public String createUserForm(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleService.listRoles());
        return "user-create";
    }

    @PostMapping("/admin/user-create")
    public String createUser(@ModelAttribute("user") User user,
                             BindingResult bindingResult){
        if (bindingResult.hasErrors()) { return "/user-create"; }
        else {

            userService.saveUser(user);
        }
        return "redirect:/admin";
    }

    @GetMapping("/admin/user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteById(id);
        return "redirect:/admin";
    }

    @GetMapping("/admin/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model){
        User user = userService.findById(id);
        model.addAttribute("user", user);
        model.addAttribute("roles", roleService.listRoles());

        return "user-update";
    }

    @PostMapping("/admin/user-update")
    public String updateUser(User user,BindingResult bindingResult){
        if (bindingResult.hasErrors()) { return "/user-update"; }
        else userService.saveUser(user);
        return "redirect:/admin";
    }
}
