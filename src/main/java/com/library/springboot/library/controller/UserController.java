package com.library.springboot.library.controller;

import com.library.springboot.library.entity.Book;
import com.library.springboot.library.entity.User;
import com.library.springboot.library.repo.BookRepo;
import com.library.springboot.library.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepo userRepo;
    @Autowired
    BookRepo bookRepo;

    @GetMapping("/save")
    public String createUserPage(Model model){
        model.addAttribute("user", new User());
        return "CreateUserPage";
    }



}
