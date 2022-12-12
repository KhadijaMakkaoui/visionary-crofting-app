package com.example.visionarycroftingmvc.service.IService;


import com.example.visionarycroftingmvc.entity.CommandeItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICommandeItemService {
    CommandeItem addProductToCommandeItem(CommandeItem commandeItem);

    void deleteByRef(String ref);

    CommandeItem findByRef(String ref);

    List<CommandeItem> findAll();

    List<CommandeItem> getCommandeItemByQuantityGreaterThan(int quantity);
}
