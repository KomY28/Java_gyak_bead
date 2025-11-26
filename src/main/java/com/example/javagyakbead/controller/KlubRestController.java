package com.example.javagyakbead.controller;

import com.example.javagyakbead.entity.Klub;
import com.example.javagyakbead.repository.KlubRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Fontos: Nem sima @Controller!
@RequestMapping("/api/klubok") // Minden cím így kezdődik majd: /api/klubok
public class KlubRestController {

    private KlubRepository klubRepository;

    public KlubRestController(KlubRepository klubRepository) {
        this.klubRepository = klubRepository;
    }

    // 1. GET: Összes klub lekérése
    @GetMapping
    public List<Klub> getAllKlub() {
        return klubRepository.findAll();
    }

    // 2. GET: Egy klub lekérése ID alapján
    @GetMapping("/{id}")
    public Klub getKlubById(@PathVariable Long id) {
        Optional<Klub> klub = klubRepository.findById(id);
        return klub.orElse(null); // Ha nincs, null-t ad vissza
    }

    // 3. POST: Új klub létrehozása
    @PostMapping
    public Klub createKlub(@RequestBody Klub klub) {
        return klubRepository.save(klub);
    }

    // 4. PUT: Klub módosítása
    @PutMapping("/{id}")
    public Klub updateKlub(@PathVariable Long id, @RequestBody Klub klubDetails) {
        Klub klub = klubRepository.findById(id).orElse(null);
        if (klub != null) {
            klub.setCsapatnev(klubDetails.getCsapatnev());
            return klubRepository.save(klub);
        }
        return null;
    }

    // 5. DELETE: Klub törlése
    @DeleteMapping("/{id}")
    public void deleteKlub(@PathVariable Long id) {
        klubRepository.deleteById(id);
    }
}