package com.example.javagyakbead.controller;

import com.example.javagyakbead.repository.UzenetRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MessageController {

    private UzenetRepository uzenetRepository;

    public MessageController(UzenetRepository uzenetRepository) {
        this.uzenetRepository = uzenetRepository;
    }

    @GetMapping("/messages")
    public String listMessages(Model model) {
        // Itt használjuk az új rendezett lekérdezést
        model.addAttribute("uzenetek", uzenetRepository.findAllByOrderByKuldesIdejeDesc());
        return "messages";
    }
}