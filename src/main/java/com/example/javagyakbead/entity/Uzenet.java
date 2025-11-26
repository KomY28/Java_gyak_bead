package com.example.javagyakbead.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "uzenetek")
public class Uzenet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "A név megadása kötelező!")
    @Size(min = 2, message = "A név legalább 2 karakter legyen!")
    private String nev;

    @NotEmpty(message = "Az email cím megadása kötelező!")
    @Email(message = "Érvényes email címet adjon meg!")
    private String email;

    @NotEmpty(message = "Az üzenet nem lehet üres!")
    @Size(min = 10, message = "Az üzenet legalább 10 karakter legyen!")
    @Column(columnDefinition = "TEXT") // Hosszú szövegnek
    private String szoveg;

    private LocalDateTime kuldesIdeje;

    // Getters és Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNev() { return nev; }
    public void setNev(String nev) { this.nev = nev; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSzoveg() { return szoveg; }
    public void setSzoveg(String szoveg) { this.szoveg = szoveg; }

    public LocalDateTime getKuldesIdeje() { return kuldesIdeje; }
    public void setKuldesIdeje(LocalDateTime kuldesIdeje) { this.kuldesIdeje = kuldesIdeje; }
}