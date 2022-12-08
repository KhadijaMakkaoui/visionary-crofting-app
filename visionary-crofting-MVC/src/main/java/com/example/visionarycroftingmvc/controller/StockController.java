package com.example.visionarycroftingmvc.controller;

import com.example.visionarycroftingmvc.entity.Stock;
import com.example.visionarycroftingmvc.service.StockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/stock")
public class StockController {

    @Autowired
    StockService stockService;

    @GetMapping("/allstocks")
    public List<Stock> getAllStocks(){
        return stockService.getAllStock();
    }

    @PostMapping("/addstock")
    public Object saveStock(@RequestBody Stock stock){
        Stock stockByEmail = stockService.findByEmail(stock.getEmail());
        Stock stockByTele = stockService.findByTelephone(stock.getTelephone());
        if(stock.getNom() == null || stock.getPassword() == null
        || stock.getEmail() == null || stock.getAdresse()==null || stock.getTelephone() == null){
            return "completer les information svp";
        }else if(stockByEmail != null) {
            return "ce email "+stock.getEmail()+" exsite déja";
        }else if (stockByTele !=null){
            return "ce numero de telephone "+stock.getTelephone()+" exsite déja";
        }
        else{
            return stockService.saveStock(stock);
        }
    }

    @PutMapping("/update/id/{idStock}")
    public Object updateStock(@RequestBody Stock stock,@PathVariable int idStock){
        Stock stock1 = stockService.findOneStock(idStock);
        stock1.setAdresse(stock.getAdresse());
        stock1.setEmail(stock.getEmail());
        stock1.setNom(stock.getNom());
        stock1.setPassword(stock.getPassword());
        stock1.setTelephone(stock.getTelephone());
        //stock1.setAppeleOffres(stock.getAppeleOffres());
        return stockService.updateStock(stock1);
    }

    @GetMapping("/OneStock/id/{idStock}")
    public Stock findOneStock(@PathVariable int idStock){
        return stockService.findOneStock(idStock);
    }
}
