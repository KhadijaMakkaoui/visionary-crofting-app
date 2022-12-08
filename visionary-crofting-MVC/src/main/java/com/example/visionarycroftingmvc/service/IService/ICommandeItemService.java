package com.example.visionarycroftingmvc.service.IService;


import com.example.visionarycroftingmvc.entity.CommandeItems;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICommandeItemService {
    CommandeItems save(CommandeItems commandeItems);

    void deleteByRef(String ref);

    CommandeItems findByRef(String ref);

    List<CommandeItems> findAll();

    List<CommandeItems> getCommandeItemByQuantityGreaterThan(int quantity);
}
