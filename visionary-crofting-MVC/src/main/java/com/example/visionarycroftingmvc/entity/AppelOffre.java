package com.example.visionarycroftingmvc.entity;

import javax.persistence.*;

@Entity
@Table
public class AppelOffre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String reference;
    @Enumerated(EnumType.STRING)
    private StatusAppelOffre statusAppelOffre;
    @ManyToOne
    private Produit produit;

    @ManyToOne
    private Stock stock;

    @ManyToOne
    Fornisseur fournisseur;

    public AppelOffre(Integer id, String reference, StatusAppelOffre statusAppelOffre, Produit produit, Stock stock, Fornisseur fournisseur) {
        this.id = id;
        this.reference = reference;
        this.statusAppelOffre = statusAppelOffre;
        this.produit = produit;
        this.stock = stock;
        this.fournisseur = fournisseur;
    }

    public AppelOffre(String reference, StatusAppelOffre statusAppelOffre, Produit produit, Stock stock, Fornisseur fournisseur) {
        this.reference = reference;
        this.statusAppelOffre = statusAppelOffre;
        this.produit = produit;
        this.stock = stock;
        this.fournisseur = fournisseur;
    }

    public AppelOffre() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public StatusAppelOffre getStatusAppelOffre() {
        return statusAppelOffre;
    }

    public void setStatusAppelOffre(StatusAppelOffre statusAppelOffre) {
        this.statusAppelOffre = statusAppelOffre;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Fornisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fornisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    @Override
    public String toString() {
        return "AppelOffre{" +
                "id=" + id +
                ", reference='" + reference + '\'' +
                ", statusAppelOffre=" + statusAppelOffre +
                ", Produit=" + produit +
                ", stock=" + stock +
                ", fournisseur=" + fournisseur +
                '}';
    }
}
