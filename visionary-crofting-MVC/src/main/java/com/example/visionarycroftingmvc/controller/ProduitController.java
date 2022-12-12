package com.example.visionarycroftingmvc.controller;

import com.example.visionarycroftingmvc.entity.Produit;
import com.example.visionarycroftingmvc.service.ProduitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/produits")
public class ProduitController {

    ProduitService produitService;

    public ProduitController(ProduitService produitService) { this.produitService = produitService; }

    @GetMapping
    public String getAllProduits(Model model){
        model.addAttribute("produits",produitService.getAllProduits());
        return "index";
    }



    @GetMapping("{id}")
    public String getProduitById(@PathVariable("id") Long produitId,Model model) {
        model.addAttribute("produit", produitService.getProduitById(produitId));
        return "product-details";
    }

   /* @GetMapping("/{category}")
    public List<Produit> getAllProduitsByCategory(@PathVariable int category){

        return produitService.findProuitsByCategory(category);

    }*/
    @PostMapping
    public Produit addProduit(@RequestBody Produit produit){
        return produitService.addProduit(produit);
    }

    @PutMapping
    public Produit updateProduit(@RequestBody Produit produit, @PathVariable Long produitId){
        return produitService.updateProduit(produit, produitId);
    }

}
