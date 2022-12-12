package com.example.visionarycroftingmvc.service.IService;

import com.example.visionarycroftingmvc.entity.CommandeItem;
import com.example.visionarycroftingmvc.entity.Produit;


import java.util.List;

public interface IProduitService {

    Produit addProduit(Produit produit);
    Produit updateProduit(Produit produit, Long productId);
    Produit getProduitById(Long id);
    List<Produit> getAllProduits();
    List<Produit> findProuitsByCategory(int category);
    void updateProduitQuantity(Produit produit1, CommandeItem commandeItem);

}
