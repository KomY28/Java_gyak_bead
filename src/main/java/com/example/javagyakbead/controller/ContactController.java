package com.example.javagyakbead.controller;

import com.example.javagyakbead.entity.Uzenet;
import com.example.javagyakbead.repository.UzenetRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
public class ContactController {

    private UzenetRepository uzenetRepository;

    public ContactController(UzenetRepository uzenetRepository) {
        this.uzenetRepository = uzenetRepository;
    }

    // Űrlap megjelenítése
    @GetMapping("/contact")
    public String showContactForm(Model model) {
        model.addAttribute("uzenet", new Uzenet());
        return "contact";
    }

    // Űrlap feldolgozása
    @PostMapping("/contact")
    public String sendMessage(@Valid @ModelAttribute("uzenet") Uzenet uzenet,
                              BindingResult bindingResult,
                              Model model) {

        // 1. Validáció ellenőrzése: Ha hiba van, visszaküldjük az űrlapot a hibákkal
        if (bindingResult.hasErrors()) {
            return "contact";
        }

        // 2. Ha minden oké, beállítjuk a küldés idejét és mentünk
        uzenet.setKuldesIdeje(LocalDateTime.now());
        uzenetRepository.save(uzenet);

        // 3. Sikeres mentés után visszairányítunk egy visszajelzéssel
        return "redirect:/contact?success";
    }
}