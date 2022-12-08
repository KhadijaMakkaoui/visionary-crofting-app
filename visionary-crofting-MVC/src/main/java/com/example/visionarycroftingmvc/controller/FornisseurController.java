package com.example.visionarycroftingmvc.controller;

import com.example.visionarycroftingmvc.entity.Fornisseur;
import com.example.visionarycroftingmvc.service.IService.IFornisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornisseur")
public class FornisseurController {

    @Autowired
    IFornisseurService fornisseurService;

    @GetMapping("/allfornisseurs")
    public List<Fornisseur> gettAllFornisseur(){
        return fornisseurService.getAllFornisseurs();
    }

    @PostMapping("/addfornisseur")
    public Object saveFornisseur(@RequestBody Fornisseur fornisseur){
        Fornisseur fornisseurByEmail = fornisseurService.findByEmail(fornisseur.getEmail());
        Fornisseur fornisseurByTelephone = fornisseurService.findByTelephone(fornisseur.getTelephone());
        if(fornisseur.getEmail() == null || fornisseur.getPassword() == null
        || fornisseur.getNom() == null || fornisseur.getTelephone() == null){
            return "les information de Fournisseur est incomplit";
        }else if(fornisseurByEmail != null){
            return "ce email "+fornisseur.getEmail()+" est deja existe";
        }else if(fornisseurByTelephone != null){
            return "ce numero de telephone "+ fornisseur.getTelephone()+" est deja existe";
        }else
        return fornisseurService.saveFornisseur(fornisseur);
    }
}
