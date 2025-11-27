package com.example.javagyakbead.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "labdarugok")
public class Labdarugo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer mezszam;
    private String utonev;
    private String vezeteknev;
    private Date szulido;
    private Integer magyar;
    private Integer kulfoldi;
    private Integer ertek;

    // Kapcsolat a Klub táblával
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "klubid", referencedColumnName = "id") // A képen "klub" a mezőnév, de valószínűleg "klubid"-re gondolt, ahogy a sémán van
    @JsonIgnore
    private Klub klub;

    // Kapcsolat a Poszt táblával
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "posztid", referencedColumnName = "id") // A képen "posztid"
    @JsonIgnore
    private Poszt poszt;

    // Getters és Setters (a teljesség igénye nélkül)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getVezeteknev() { return vezeteknev; }
    public void setVezeteknev(String vezeteknev) { this.vezeteknev = vezeteknev; }

    public String getUtonev() { return utonev; }
    public void setUtonev(String utonev) { this.utonev = utonev; }

    public Integer getErtek() { return ertek; }
    public void setErtek(Integer ertek) { this.ertek = ertek; }

    public Klub getKlub() { return klub; }
    public void setKlub(Klub klub) { this.klub = klub; }

    public Poszt getPoszt() { return poszt; }
    public void setPoszt(Poszt poszt) { this.poszt = poszt; }
    public Integer getMezszam() {
        return mezszam;
    }

    public void setMezszam(Integer mezszam) {
        this.mezszam = mezszam;
    }

    // Ha már ott vagyunk, a többi hiányzót is pótoljuk, hogy később ne legyen gond:

    public Date getSzulido() {
        return szulido;
    }

    public void setSzulido(Date szulido) {
        this.szulido = szulido;
    }

    public Integer getMagyar() {
        return magyar;
    }

    public void setMagyar(Integer magyar) {
        this.magyar = magyar;
    }

    public Integer getKulfoldi() {
        return kulfoldi;
    }

    public void setKulfoldi(Integer kulfoldi) {
        this.kulfoldi = kulfoldi;
    }
}
