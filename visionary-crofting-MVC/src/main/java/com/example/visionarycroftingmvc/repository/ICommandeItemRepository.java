package com.example.visionarycroftingmvc.repository;


import com.example.visionarycroftingmvc.entity.CommandeItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICommandeItemRepository extends JpaRepository<CommandeItems,Long> {
    public void deleteByReference(String reference);
    public CommandeItems findCommandeItemsByReference(String reference);
    List<CommandeItems> findCommandeItemsByQuantityGreaterThan(int quantity);
}
