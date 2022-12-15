package com.example.visionarycroftingmvc.controller;

import com.example.visionarycroftingmvc.entity.Commande;
import com.example.visionarycroftingmvc.entity.CommandeItem;
import com.example.visionarycroftingmvc.service.IService.ICommandeItemService;
import com.example.visionarycroftingmvc.service.IService.ICommandeService;
import com.example.visionarycroftingmvc.service.IService.IProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/commandeItem")
public class CommandItemController {

    @Autowired
    ICommandeItemService commandeItemService;

    @Autowired
    ICommandeService commandeService;

    @Autowired
    IProduitService produitService;


    @GetMapping("/all_items")
    public String getAll(Model model){
        model.addAttribute("commandeItems",commandeItemService.findAll());
        return "card";
    }

    @PostMapping("/add")
    public String add(@Valid CommandeItem commandeItem, BindingResult bindingResult, Model model, RedirectAttributes atts){
        //check if commandeItem is null
        if(commandeItem == null || commandeItem==new CommandeItem()){
            throw new RuntimeException("CommandeItem is null");
        }
        if(bindingResult.hasErrors()){
            atts.addAttribute("id",commandeItem.getProduit().getId());
            return "redirect:/produits/{id}";
        }
        commandeItemService.addProductToCommandeItem(commandeItem);
        //redirect to controller
        return "redirect:/commandeItem/all_items";

    }
    @Transactional
    @GetMapping("{ref}")
    public String deleteByRef(@PathVariable String ref){
        commandeItemService.deleteByRef(ref);
        return "redirect:/commandeItem/all_items";
    }

    @GetMapping("/quantity/{quantity}")
    public List<CommandeItem> getCommandeItemByQuantityGreaterThan(@PathVariable int quantity){
        return commandeItemService.getCommandeItemByQuantityGreaterThan(quantity);
    }











}
