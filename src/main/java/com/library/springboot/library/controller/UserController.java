package com.library.springboot.library.controller;

import com.library.springboot.library.entity.User;
import com.library.springboot.library.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepo userRepo;

    @GetMapping("/save")
    public String createUserPage(Model model){
        model.addAttribute("user", new User());
        return "CreateUserPage";
    }

    @PostMapping("/save")
    public String createUser(@ModelAttribute User tmpUser){
        userRepo.save(tmpUser);
        return "redirect:/";
    }
}
