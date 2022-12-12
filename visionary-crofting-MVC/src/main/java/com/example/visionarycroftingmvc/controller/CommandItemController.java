package com.example.visionarycroftingmvc.controller;

import com.example.visionarycroftingmvc.entity.Commande;
import com.example.visionarycroftingmvc.entity.CommandeItem;
import com.example.visionarycroftingmvc.service.IService.ICommandeItemService;
import com.example.visionarycroftingmvc.service.IService.ICommandeService;
import com.example.visionarycroftingmvc.service.IService.IProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;


@Controller
@RequestMapping("/commandeItem")
public class CommandItemController {

    @Autowired
    ICommandeItemService commandeItemService;

    @Autowired
    ICommandeService commandeService;

    @Autowired
    IProduitService produitService;


    @GetMapping("/all_items")
    public List<CommandeItem> findAll(){
        return commandeItemService.findAll();
    }

    @PostMapping("/add")
    public String add(CommandeItem commandeItem, Model model){

        /*if (result.hasErrors()) {
            commandeItems.setProduit(produitService.getProduitById(produit.getId()));
            model.addAttribute("commandeItems", commandeItems);
            return "index";
        }
        commandeItemService.addProductToCommandeItem(commandeItems);*/
        System.out.println(commandeItem.getProduit().getNom());
        commandeItemService.addProductToCommandeItem(commandeItem);
        return "card";
    }

   /* Produit produit1 = produitService.getProduitById(produit_id);
        commandeItems.setProduit(produit1);
        commandeItems.setQuantity(produit1.getQuantity());
        //Prix=prix*uantity
        commandeItemService.save(commandeItems);*/

    //}
   /* @GetMapping("/add-commande-items/commande/{id}/produit/{produit}")
    public void save(@RequestBody CommandeItems commandeItems,@PathVariable Long id,@PathVariable Long produit){
        Produit produit1 = produitService.getProduitById(produit);
        Commande commande= commandeService.findById(id).get();
        if(produit1 !=null || commande !=null || commandeItems.getQuantity()>0 || !(commande.getStatus() == StatusCommande.EFFECTUER)) {
            assert produit1 != null;
            commandeItems.setPrix(produit1.getPrix_initial() * (commandeItems.getQuantity()));
            commandeItems.setCommande(commande);
            commandeItems.setProduit(produit1);
            commandeItems.setReference(GenerateReference.applyGenerateReference());
            commandeItemService.save(commandeItems);
            commandeService.updateCommandePrix(commande);
            produitService.updateProduitQuantity(produit1, commandeItems);
        }else{
            throw new IllegalStateException("Un erreur est Servenue !");
        }

    }*/

    @Transactional
    @DeleteMapping("/commande/{id}/delete_item/{ref}")
    public void deleteByRef(@PathVariable Long id ,@PathVariable String ref){
        commandeItemService.deleteByRef(ref);
        if(commandeItemService.findByRef(ref)==null){
            Commande commande= commandeService.findById(id).get();
            commandeService.updateCommandePrix(commande);
        }

    }

    @GetMapping("/quantity/{quantity}")
    public List<CommandeItem> getCommandeItemByQuantityGreaterThan(@PathVariable int quantity){
        return commandeItemService.getCommandeItemByQuantityGreaterThan(quantity);
    }











}
