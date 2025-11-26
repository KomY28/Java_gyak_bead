package com.example.javagyakbead.controller;

import com.example.javagyakbead.entity.Labdarugo;
import com.example.javagyakbead.repository.LabdarugoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// ÚJ IMPORT:
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Controller
public class DatabaseController {

    private LabdarugoRepository labdarugoRepository;

    public DatabaseController(LabdarugoRepository labdarugoRepository) {
        this.labdarugoRepository = labdarugoRepository;
    }

    @GetMapping("/database")
    @Transactional // <--- EZ A KULCS A HIBA ELLEN!
    public String listDatabase(Model model) {
        // Lekérjük az összes játékost
        List<Labdarugo> list = labdarugoRepository.findAll();

        model.addAttribute("labdarugok", list);

        return "database";
    }
}