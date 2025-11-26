package com.example.javagyakbead.controller;

import com.example.javagyakbead.entity.Klub;
import com.example.javagyakbead.repository.KlubRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.transaction.annotation.Transactional; // Biztos ami biztos

import java.util.ArrayList;
import java.util.List;

@Controller
public class ChartController {

    private KlubRepository klubRepository;

    public ChartController(KlubRepository klubRepository) {
        this.klubRepository = klubRepository;
    }

    @GetMapping("/diagram")
    @Transactional
    public String showDiagram(Model model) {
        try {
            // 1. Lekérjük az összes klubot
            List<Klub> klubok = klubRepository.findAll();

            List<String> labels = new ArrayList<>();
            List<Integer> data = new ArrayList<>();

            // 3. Végigmegyünk a klubokon
            for (Klub k : klubok) {
                labels.add(k.getCsapatnev());

                // Null check és méret lekérés
                if (k.getLabdarugok() != null) {
                    data.add(k.getLabdarugok().size());
                } else {
                    data.add(0);
                }
            }

            model.addAttribute("labels", labels);
            model.addAttribute("data", data);

            return "diagram"; // Ha minden jó, betölti a diagramot

        } catch (Exception e) {
            // HA HIBA VAN: Kiírjuk a hibát a konzolra és a weboldalra is
            e.printStackTrace();
            model.addAttribute("errorMessage", "Hiba történt: " + e.getMessage() + " --- " + e.toString());
            return "error_page"; // Egy külön hibaoldalra irányítjuk
        }
    }
}