package com.example.visionarycroftingmvc.service;

import com.example.visionarycroftingmvc.entity.Commande;
import com.example.visionarycroftingmvc.entity.CommandeItem;
import com.example.visionarycroftingmvc.entity.StatusCommande;
import com.example.visionarycroftingmvc.repository.ICommandeRepository;
import com.example.visionarycroftingmvc.service.IService.ICommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeService implements ICommandeService {

    @Autowired
    ICommandeRepository commandeRepository;

    @Override
    public Commande save(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public List<Commande> findAll() {
        return commandeRepository.findAll();
    }

    @Override
    public Optional<Commande> findById(Long id) {
        return commandeRepository.findById(id);
    }

    @Override
    public Commande findByReference(String ref) {
        return commandeRepository.findCommandeByReference(ref);
    }

    @Override
    public List<Commande> findEffectuedCommands() {
        return commandeRepository.findCommandesByStatus(StatusCommande.EFFECTUER);
    }

    public void updateCommandePrix( Commande commande){
        List<CommandeItem> items= commande.getCommandeItems();
        Float prix= (float) 0;
        for(CommandeItem item : items){
            System.out.println(item.getReference());
            prix+=item.getPrix();
        }
        System.out.println(prix);
        commande.setPrixTotal(prix);
        save(commande);
    }

    @Override
    public void saveCommandeItems(Commande commande, List<CommandeItem> commandeItems) {
        commandeRepository.save(commande);
    }


}
