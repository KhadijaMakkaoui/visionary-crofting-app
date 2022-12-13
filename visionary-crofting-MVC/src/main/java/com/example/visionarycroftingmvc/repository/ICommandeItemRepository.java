package com.example.visionarycroftingmvc.repository;


import com.example.visionarycroftingmvc.entity.CommandeItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICommandeItemRepository extends JpaRepository<CommandeItem,Long> {
    public void deleteByReference(String reference);
    public CommandeItem findCommandeItemByReference(String reference);
    public List<CommandeItem> findCommandeItemByQuantityGreaterThan(int quantity);
    public CommandeItem findCommandeItemByProduitId(Long id);
}
