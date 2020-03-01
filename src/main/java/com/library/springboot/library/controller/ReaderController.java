package com.library.springboot.library.controller;

import com.library.springboot.library.entity.Reader;
import com.library.springboot.library.repo.ReaderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reader")
public class ReaderController {

    @Autowired
    ReaderRepo readerRepo;

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
}
