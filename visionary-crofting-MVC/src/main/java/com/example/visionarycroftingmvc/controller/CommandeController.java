package com.example.visionarycroftingmvc.controller;


import com.example.visionarycroftingmvc.entity.Commande;
import com.example.visionarycroftingmvc.entity.StatusCommande;
import com.example.visionarycroftingmvc.service.IService.ICommandeService;
import com.example.visionarycroftingmvc.utils.GenerateReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/commande")
public class CommandeController {

    @Autowired
    ICommandeService commandeService;

    @PostMapping("/add_commande")
    public Commande save(@RequestBody Commande commande ) {
        commande.setDate(LocalDate.now());
        commande.setReference(GenerateReference.applyGenerateReference());
        return commandeService.save(commande);
    }

    @GetMapping("/all_commande")
    public List<Commande> findAll(){
        return commandeService.findAll();
    }

    @GetMapping("/commande_id/{id}")
    public Optional<Commande> findById(@PathVariable Long id){
        return commandeService.findById(id);
    }

    @GetMapping("/commande_ref/{ref}")
    public Commande findByReference(@PathVariable String ref){
        return commandeService.findByReference(ref);
    }

    @PutMapping ("/passe_commande/{ref}")
    public Object updateStatusCommande(@PathVariable String ref){
        Commande commande=commandeService.findByReference(ref);
        if(commande!=null || commande.getStatus()!= StatusCommande.EFFECTUER){
             commande.setStatus(StatusCommande.EFFECTUER);
             return commandeService.save(commande);
        }else{
            return "Un erreur est servenue , verifier votre commande";
        }
    }

    @GetMapping ("/commandes_effectuer")
    public List<Commande> getEffectuedCommands(){
        return commandeService.findEffectuedCommands();
    }


    @PostMapping("/savecommande")
    public void saveCommande(@RequestBody Commande commande ){
        commandeService.saveCommandeItems(commande,commande.getCommandeItems());
    }

}
