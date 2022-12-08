package com.example.visionarycroftingmvc.service.IService;

import com.example.visionarycroftingmvc.entity.Fornisseur;

import java.util.List;

public interface IFornisseurService {
    public Fornisseur saveFornisseur(Fornisseur fornisseur);
    public Fornisseur findByEmail(String email);
    public List<Fornisseur> getAllFornisseurs();
    public Fornisseur findByTelephone(String telephone);
}
