package com.example.visionarycroftingmvc.service.IService;


import com.example.visionarycroftingmvc.entity.Stock;

import java.util.List;

public interface IStockService {
    public Stock saveStock(Stock stock);

    public Stock findByEmail(String email);

    public Stock updateStock(Stock stock);

    public Stock findOneStock(int id);

    public List<Stock> getAllStock();

    public Stock findByTelephone(String telephone);

}
