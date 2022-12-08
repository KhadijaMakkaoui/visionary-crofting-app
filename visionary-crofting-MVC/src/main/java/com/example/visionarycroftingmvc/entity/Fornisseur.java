package com.example.visionarycroftingmvc.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Fornisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private String nom;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String telephone;
    private String password;

    @OneToMany(mappedBy = "fournisseur")
    private List<AppelOffre> appelOffres;

    public Fornisseur() {
    }

    public Fornisseur(String nom, String email, String telephone, String password, List<AppelOffre> appelOffres) {
        this.nom = nom;

        this.email = email;
        this.telephone = telephone;
        this.password = password;
        this.appelOffres = appelOffres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<AppelOffre> getAppelOffres() {
        return appelOffres;
    }

    public void setAppelOffres(List<AppelOffre> appelOffres) {
        this.appelOffres = appelOffres;
    }

    @Override
    public String toString() {
        return "Fornisseur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", password='" + password + '\'' +
                ", appelOffres=" + appelOffres +
                '}';
    }
}
