package com.example.visionarycroftingmvc.service;

import com.example.visionarycroftingmvc.entity.CommandeItems;
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
    public CommandeItems save(CommandeItems commandeItems) {
        return commandeItemRepository.save(commandeItems);
    }

    @Override
    public void deleteByRef(String ref) {
        commandeItemRepository.deleteByReference(ref);
    }

    @Override
    public CommandeItems findByRef(String ref) {
        return commandeItemRepository.findCommandeItemsByReference(ref);
    }

    @Override
    public List<CommandeItems> findAll() {
        return commandeItemRepository.findAll();
    }

    @Override
    public List<CommandeItems> getCommandeItemByQuantityGreaterThan(int quantity) {
        return commandeItemRepository.findCommandeItemsByQuantityGreaterThan(quantity);
    }
}
