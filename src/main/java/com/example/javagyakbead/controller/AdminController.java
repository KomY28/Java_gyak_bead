package com.example.javagyakbead.controller;

import com.example.javagyakbead.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    private UserRepository userRepository;

    public AdminController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/admin")
    public String adminPage(Model model) {
        // Az admin oldalra átadhatjuk például az összes regisztrált felhasználót listázásra
        model.addAttribute("users", userRepository.findAll());
        return "admin";
    }
}