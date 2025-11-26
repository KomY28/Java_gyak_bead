package com.example.javagyakbead.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "NB1 Statisztikák");
        return "index";
    }

    // EZT A RÉSZT KELL HOZZÁADNI:
    @GetMapping("/rest")
    public String showRestApiPage() {
        return "rest"; // Ez tölti be a templates/rest.html fájlt
    }
}