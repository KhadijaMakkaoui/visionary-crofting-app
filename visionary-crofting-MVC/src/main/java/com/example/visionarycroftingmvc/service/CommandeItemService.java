package com.example.visionarycroftingmvc.service;

import com.example.visionarycroftingmvc.entity.CommandeItem;
import com.example.visionarycroftingmvc.repository.ICommandeItemRepository;
import com.example.visionarycroftingmvc.service.IService.ICommandeItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeItemService implements ICommandeItemService {
    @Autowired
    ICommandeItemRepository commandeItemRepository;

    @Override
    public CommandeItem addProductToCommandeItem(CommandeItem commandeItem) {
        if(commandeItem.getQuantity() > commandeItem.getProduit().getQuantity()){
            throw new RuntimeException("Quantity is not available");
        }

        return commandeItemRepository.save(commandeItem);
    }

    @Override
    public void deleteByRef(String ref) {
        commandeItemRepository.deleteByReference(ref);
    }

    @Override
    public CommandeItem findByRef(String ref) {
        return commandeItemRepository.findCommandeItemsByReference(ref);
    }

    @Override
    public List<CommandeItem> findAll() {
        return commandeItemRepository.findAll();
    }

    @Override
    public List<CommandeItem> getCommandeItemByQuantityGreaterThan(int quantity) {
        return commandeItemRepository.findCommandeItemsByQuantityGreaterThan(quantity);
    }
}
