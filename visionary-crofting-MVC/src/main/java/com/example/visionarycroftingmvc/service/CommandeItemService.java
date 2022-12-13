package com.example.visionarycroftingmvc.service;

import com.example.visionarycroftingmvc.entity.CommandeItem;
import com.example.visionarycroftingmvc.entity.Produit;
import com.example.visionarycroftingmvc.repository.ICommandeItemRepository;
import com.example.visionarycroftingmvc.service.IService.ICommandeItemService;
import com.example.visionarycroftingmvc.utils.GenerateReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeItemService implements ICommandeItemService {
    @Autowired
    ICommandeItemRepository commandeItemRepository;

    @Override
    public CommandeItem addProductToCommandeItem(CommandeItem commandeItem) {
        if(commandeItem.getQuantity()<=0 ){
            throw new RuntimeException("Quantity must bigger than 0");
        }
        if(commandeItem.getProduit()==null || commandeItem.getProduit()==new Produit()){
            throw new RuntimeException("Produit is null or empty");
        }

        //check if product exist
        if(commandeItem.getProduit().getId()==null){
            throw new RuntimeException("Produit does not exist");
        }else{
            //check if product is available
            if(commandeItem.getProduit().getQuantity()<=0){
                throw new RuntimeException("Product is not available");
            }else {
                //check if quantity in stock is bigger than quantity in commandeItem
                if(commandeItem.getQuantity() > commandeItem.getProduit().getQuantity()){
                    throw new RuntimeException("Quantity is not available in stock");
                }else{
                    //check if product is already in an existing commandeItem
                    if (commandeItemRepository.findCommandeItemByProduitId(commandeItem.getProduit().getId()) != null) {
                        //get the commandeItem containing the product
                        CommandeItem commandeItem1 = commandeItemRepository.findCommandeItemByProduitId(commandeItem.getProduit().getId());
                        //update the quantity
                        commandeItem1.setQuantity(commandeItem1.getQuantity() + commandeItem.getQuantity());
                        //update the price
                        commandeItem1.setPrix(commandeItem1.getProduit().getPrix_initial() * commandeItem1.getQuantity());
                        return commandeItemRepository.save(commandeItem1);
                    } else {
                        commandeItem.setReference(GenerateReference.applyGenerateReference());
                        System.out.println("Reference: " + commandeItem.getReference());
                        commandeItem.setPrix(commandeItem.getProduit().getPrix_initial()*commandeItem.getQuantity());
                        //save commandeItem
                        return commandeItemRepository.save(commandeItem);
                    }

                }
            }
        }

    }

    @Override
    public void deleteByRef(String ref) {
        commandeItemRepository.deleteByReference(ref);
    }

    @Override
    public CommandeItem findByRef(String ref) {
        return commandeItemRepository.findCommandeItemByReference(ref);
    }

    @Override
    public List<CommandeItem> findAll() {
        return commandeItemRepository.findAll();
    }

    @Override
    public List<CommandeItem> getCommandeItemByQuantityGreaterThan(int quantity) {
        return commandeItemRepository.findCommandeItemByQuantityGreaterThan(quantity);
    }
}
