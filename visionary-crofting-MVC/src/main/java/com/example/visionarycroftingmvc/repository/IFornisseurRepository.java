package com.example.visionarycroftingmvc.repository;

import com.example.visionarycroftingmvc.entity.Fornisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFornisseurRepository extends JpaRepository<Fornisseur,Integer> {
    public Fornisseur findByEmail(String email);
    public Fornisseur findByTelephone(String telephone);
}
