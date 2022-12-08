package com.example.visionarycroftingmvc.repository;

import com.example.visionarycroftingmvc.entity.Commande;
import com.example.visionarycroftingmvc.entity.StatusCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICommandeRepository extends JpaRepository<Commande,Long> {
    Commande findCommandeByReference(String reference);

    List<Commande> findCommandesByStatus(StatusCommande status);

    @Query("select c FROM Commande c where c.prixTotal>:val")
    public List<Commande> getCommandes(Long val);


}
