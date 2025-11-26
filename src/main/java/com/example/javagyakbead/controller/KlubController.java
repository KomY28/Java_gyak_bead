package com.example.javagyakbead.controller;

import com.example.javagyakbead.entity.Klub;
import com.example.javagyakbead.repository.KlubRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class KlubController {

    private KlubRepository klubRepository;

    public KlubController(KlubRepository klubRepository) {
        this.klubRepository = klubRepository;
    }

    // 1. READ: Tábla megjelenítése (Lista)
    @GetMapping("/crud")
    public String listKlubok(Model model) {
        List<Klub> klubok = klubRepository.findAll();
        model.addAttribute("klubok", klubok);
        return "crud_list";
    }

    // 2. CREATE: Új rekord űrlap megjelenítése
    @GetMapping("/crud/new")
    public String showNewForm(Model model) {
        model.addAttribute("klub", new Klub());
        model.addAttribute("pageTitle", "Új Klub Hozzáadása");
        return "crud_form";
    }

    // 3. CREATE & UPDATE: Mentés folyamata
    @PostMapping("/crud/save")
    public String saveKlub(@ModelAttribute("klub") Klub klub) {
        klubRepository.save(klub);
        return "redirect:/crud";
    }

    // 4. UPDATE: Szerkesztés űrlap megjelenítése (meglévő adatokkal)
    @GetMapping("/crud/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Optional<Klub> result = klubRepository.findById(id);
        if (result.isPresent()) {
            model.addAttribute("klub", result.get());
            model.addAttribute("pageTitle", "Klub Szerkesztése");
            return "crud_form";
        } else {
            return "redirect:/crud";
        }
    }

    // 5. DELETE: Törlés
    @GetMapping("/crud/delete/{id}")
    public String deleteKlub(@PathVariable("id") Long id) {
        klubRepository.deleteById(id);
        return "redirect:/crud";
    }
}