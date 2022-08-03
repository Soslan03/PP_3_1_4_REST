package com.example.ru.badtiev.controller;

import com.example.ru.badtiev.model.User;
import com.example.ru.badtiev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String findAll(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user,BindingResult bindingResult){

        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()) { return "user-create"; }
        else userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model){
        User user = userService.findById(id);
        model.addAttribute("user", user);

        return "user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user,BindingResult bindingResult){
        if (bindingResult.hasErrors()) { return "/user-update"; }
        else userService.saveUser(user);
        return "redirect:/users";
    }
}
