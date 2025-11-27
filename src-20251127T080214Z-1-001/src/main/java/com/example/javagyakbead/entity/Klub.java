package com.example.javagyakbead.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "klubok")
public class Klub {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String csapatnev; // pl. "Vasas FC"


    @OneToMany(mappedBy = "klub", fetch = FetchType.EAGER)
    private List<Labdarugo> labdarugok;

    // Getters és Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCsapatnev() { return csapatnev; }
    public void setCsapatnev(String csapatnev) { this.csapatnev = csapatnev; }
    public List<Labdarugo> getLabdarugok() { return labdarugok; }
    public void setLabdarugok(List<Labdarugo> labdarugok) { this.labdarugok = labdarugok; }
}