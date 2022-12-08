package com.example.visionarycroftingmvc.service;

import com.example.visionarycroftingmvc.entity.AppelOffre;
import com.example.visionarycroftingmvc.entity.StatusAppelOffre;
import com.example.visionarycroftingmvc.repository.IAppelOffreRepository;
import com.example.visionarycroftingmvc.service.IService.IAppelOffreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppelOffreService implements IAppelOffreService {
    private final IAppelOffreRepository appelOffreRepository;

    @Autowired
    public AppelOffreService(IAppelOffreRepository appelOffreRepository) {
        this.appelOffreRepository = appelOffreRepository;
    }
    public List<AppelOffre> getAppelOffres(){
        return appelOffreRepository.findAll();
    }

    public AppelOffre addAppelOffre(AppelOffre appelOffre){
        Optional<AppelOffre> appelOffreOptional=appelOffreRepository.findByReference(appelOffre.getReference());
        if(appelOffreOptional.isPresent()){
            throw new IllegalStateException("This reference already exists ");
        }
        return appelOffreRepository.save(appelOffre);
    }

    public void deleteAppelOffre(Integer id) {
        boolean exists=appelOffreRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException(
                    "AppelOffre with id "+ id+" doesn't exists"
            );
        }
        appelOffreRepository.deleteById(id);
    }

    public AppelOffre updateAppelOffre(Integer id, AppelOffre appelOffreNew){
        Optional<AppelOffre> appelOffre = appelOffreRepository.findById(id);
        if (appelOffre.isPresent()){
            AppelOffre ao=appelOffre.get();
            ao.setReference(appelOffreNew.getReference());
            ao.setStatusAppelOffre(appelOffreNew.getStatusAppelOffre());
            ao.setProduit(appelOffreNew.getProduit());
            ao.setStock(appelOffreNew.getStock());
            ao.setFournisseur(appelOffreNew.getFournisseur());

        }
         appelOffreRepository.save(appelOffre.get());
        return appelOffreNew;

    }

    @Override
    public List<AppelOffre> findByStatusAppelOffre(StatusAppelOffre statusAppelOffre) {
        return appelOffreRepository.findByStatusAppelOffre(statusAppelOffre);

    }

    @Override
    public Optional<AppelOffre> findById(Integer id) {
        return appelOffreRepository.findById(id);
    }


}
