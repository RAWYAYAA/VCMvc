package com.example.visonarycrofting.service.Implementations;

import com.example.visonarycrofting.Repository.StockRepository;
import com.example.visonarycrofting.entity.Produit;
import com.example.visonarycrofting.entity.Stock;
import com.example.visonarycrofting.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService implements ServiceInterface<Stock> {
    @Autowired
    private StockRepository stockRepository;
    @Override
    public Stock save(Stock stock) {
        return null;
    }

    @Override
    public List<Stock> findAll() {
        return stockRepository.findAll();

    }

    @Override
    public Stock update(Stock stock) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Produit findById(Long id) {

        return null;
    }

    @Override
    public Stock findByStatus() {
        return null;
    }
}
