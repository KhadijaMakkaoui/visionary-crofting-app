package com.example.visionarycroftingmvc.repository;

import com.example.visionarycroftingmvc.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IClientRepository extends JpaRepository<Client, Long> {

    public Client findByEmail(String email);
}
