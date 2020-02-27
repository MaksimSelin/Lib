package com.library.springboot.library.controller;

import com.library.springboot.library.entity.Book;
import com.library.springboot.library.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookRepo bookRepo;

    @GetMapping("/save")
    public String createBookPage(Model model){
        model.addAttribute("book", new Book());
        return "CreateBookPage";
    }

    @PostMapping("/save")
    public String createBook(@ModelAttribute Book tmpBook){
        bookRepo.save(tmpBook);
        return "redirect:/";
    }
}
