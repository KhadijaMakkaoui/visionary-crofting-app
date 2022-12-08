package com.example.visionarycroftingmvc.repository;

import com.example.visionarycroftingmvc.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStockRepository extends JpaRepository<Stock,Integer> {
    public Stock findByEmail(String email);
    public Stock findByTelephone(String telephone);

}
