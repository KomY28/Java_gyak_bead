package com.example.javagyakbead.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "posztok")
public class Poszt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nev; // pl. "bal oldali védő"

    // Kapcsolat: Egy poszton több labdarúgó is lehet
    @OneToMany(mappedBy = "poszt", fetch = FetchType.EAGER)
    private List<Labdarugo> labdarugok;

    // Getters és Setters (Lombok nélkül most kiírva)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNev() { return nev; }
    public void setNev(String nev) { this.nev = nev; }
    public List<Labdarugo> getLabdarugok() { return labdarugok; }
    public void setLabdarugok(List<Labdarugo> labdarugok) { this.labdarugok = labdarugok; }
}