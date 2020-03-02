package com.library.springboot.library.controller;

import com.library.springboot.library.entity.Book;
import com.library.springboot.library.entity.Reader;
import com.library.springboot.library.repo.BookRepo;
import com.library.springboot.library.repo.ReaderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reader")
public class ReaderController {

    @Autowired
    ReaderRepo readerRepo;

    @Autowired
    BookRepo bookRepo;

    @GetMapping("/save")
    public String saveReaderPage(Model model){
        model.addAttribute("reader", new Reader());
        return "CreateReaderPage";
    }

    @PostMapping("/save")
    public String saveReader(@ModelAttribute Reader reader){
        readerRepo.save(reader);
        return "redirect:/";
    }

    @GetMapping("/readersList")
    public String readerInfo(Model model){
        model.addAttribute("readerList", readerRepo.findAll());
        return "readersList";
    }
    @GetMapping("/addBook")
    public String addBookPage(Model model, @RequestParam("readerId") long readerId){
        model.addAttribute("readerId", readerId);
        model.addAttribute("bookList", bookRepo.findByReader(null));
        return "addBook";
    }
}
