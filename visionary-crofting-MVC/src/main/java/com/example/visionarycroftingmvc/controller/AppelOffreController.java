package com.example.visionarycroftingmvc.controller;

import com.example.visionarycroftingmvc.service.AppelOffreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("appelOffre")
public class AppelOffreController {
    @Autowired
    private AppelOffreService appelOffreService;


    @GetMapping("list")
    public String getAppelOffres(Model model){
/*
        model.addAttribute("appelOffres",appelOffreService.getAppelOffres());
*/
        return "";
    }
    /*@PostMapping
    public void addAppelOffre(@RequestBody AppelOffre appelOffre){
        if(appelOffre.getReference().isEmpty() || appelOffre.getReference() == null){
            throw new IllegalStateException("Reference is empty");
        }else if(appelOffre.getStatusAppelOffre()==null){
            throw new IllegalStateException("Status is empty");
        }
        *//*else if(appelOffre.getStock()==null){
            throw new IllegalStateException("Fornisseur is empty");
        }*//*else{
            appelOffreService.addAppelOffre(appelOffre);
        }

    }
    @DeleteMapping(path = "{id}")
    public void deleteAppelOffre(@PathVariable("id") Integer id){
        appelOffreService.deleteAppelOffre(id);

    }
    @PutMapping(path = "{id}")
    public AppelOffre updateAppelOffre(@PathVariable("id") Integer id, @RequestBody AppelOffre appelOffre){

     return appelOffreService.updateAppelOffre(id,appelOffre);
    }
    @GetMapping(path = "status/{status}")
    public List<AppelOffre> getByStatus(@PathVariable("status") String status){
        StatusAppelOffre statusAppelOffre=StatusAppelOffre.valueOf(status);
        return appelOffreService.findByStatusAppelOffre(statusAppelOffre);
    }*/
}
