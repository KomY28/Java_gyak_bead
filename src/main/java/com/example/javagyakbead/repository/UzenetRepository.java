package com.example.javagyakbead.repository;

import com.example.javagyakbead.entity.Uzenet;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UzenetRepository extends JpaRepository<Uzenet, Long> {
    // Ez a "varázs-metódus" automatikusan időrendben visszafelé (Desc) adja vissza a listát
    List<Uzenet> findAllByOrderByKuldesIdejeDesc();
}
