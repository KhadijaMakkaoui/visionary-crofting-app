package com.example.visionarycroftingmvc.controller;


import com.example.visionarycroftingmvc.entity.Client;
import com.example.visionarycroftingmvc.service.IService.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    IClientService clientService;

    @PostMapping("/register")
    public Client save(@RequestBody Client client) {
        return clientService.save(client);
    }

    @GetMapping("/allclient")
    @ResponseBody
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
         clientService.deleteById(id);
    }

    @GetMapping("client_id/{id}")
    public Optional<Client> findById(@PathVariable Long id){
        return clientService.findById(id);
    }


}
