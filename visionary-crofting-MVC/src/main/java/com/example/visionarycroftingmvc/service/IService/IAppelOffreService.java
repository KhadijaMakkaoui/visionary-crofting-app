package com.example.visionarycroftingmvc.service.IService;



import com.example.visionarycroftingmvc.entity.AppelOffre;
import com.example.visionarycroftingmvc.entity.StatusAppelOffre;

import java.util.List;
import java.util.Optional;

public interface IAppelOffreService {
    public List<AppelOffre> getAppelOffres();

    public AppelOffre addAppelOffre(AppelOffre appelOffre);

    public void deleteAppelOffre(Integer id);

    public AppelOffre updateAppelOffre(Integer id, AppelOffre appelOffre);

    public List<AppelOffre> findByStatusAppelOffre(StatusAppelOffre statusAppelOffre);

    Optional<AppelOffre> findById(Integer id);

}
