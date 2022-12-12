package com.example.visionarycroftingmvc.service.IService;

import com.example.visionarycroftingmvc.entity.Commande;
import com.example.visionarycroftingmvc.entity.CommandeItem;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ICommandeService {
    Commande save(Commande commande);
    List<Commande> findAll();
    Optional<Commande> findById(Long id);
    Commande findByReference(String ref);
    List<Commande> findEffectuedCommands();
    void updateCommandePrix(Commande commande);
    void saveCommandeItems(Commande commande , List<CommandeItem> commandeItems);
}
