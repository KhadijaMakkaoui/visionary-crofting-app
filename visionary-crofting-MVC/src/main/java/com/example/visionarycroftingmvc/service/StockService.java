package com.example.visionarycroftingmvc.service;

import com.example.visionarycroftingmvc.entity.Stock;
import com.example.visionarycroftingmvc.repository.IStockRepository;
import com.example.visionarycroftingmvc.service.IService.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService implements IStockService {

    @Autowired
    IStockRepository stockRepository;

    @Override
    public Stock saveStock(Stock stock){
        stockRepository.save(stock);
        return stock;
    }

    @Override
    public List<Stock> getAllStock(){
        return stockRepository.findAll();
    }

    @Override
    public Stock findByTelephone(String telephone) {
        return stockRepository.findByTelephone(telephone);
    }

    @Override
    public Stock updateStock(Stock stock){
        stockRepository.save(stock);
        return stock;
    }

    @Override
    public Stock findOneStock(int idStock){
        return stockRepository.findById(idStock).get();
    }

    @Override
    public Stock findByEmail(String email){
        return stockRepository.findByEmail(email);
    }
}
