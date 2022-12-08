package com.example.visionarycroftingmvc.service;

import com.example.visionarycroftingmvc.entity.Fornisseur;
import com.example.visionarycroftingmvc.repository.IFornisseurRepository;
import com.example.visionarycroftingmvc.service.IService.IFornisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornisseurService implements IFornisseurService {

    @Autowired
    IFornisseurRepository fornisseurRepository;

    @Override
    public Fornisseur saveFornisseur(Fornisseur fornisseur) {
        fornisseurRepository.save(fornisseur);
        return fornisseur;
    }

    @Override
    public Fornisseur findByEmail(String email) {
        return fornisseurRepository.findByEmail(email);
    }

    @Override
    public List<Fornisseur> getAllFornisseurs() {
        return fornisseurRepository.findAll();
    }

    @Override
    public Fornisseur findByTelephone(String telephone) {
        return fornisseurRepository.findByTelephone(telephone);
    }
}
