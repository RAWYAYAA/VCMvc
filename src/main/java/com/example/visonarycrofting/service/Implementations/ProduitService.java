package com.example.visonarycrofting.service.Implementations;

import com.example.visonarycrofting.Repository.ProduitRepository;
import com.example.visonarycrofting.Repository.StockRepository;
import com.example.visonarycrofting.entity.Produit;
import com.example.visonarycrofting.entity.Stock;
import com.example.visonarycrofting.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProduitService implements ServiceInterface<Produit> {
    Produit produit = new Produit();
    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private StockRepository stockRepository;

    @Override
    public Produit save(Produit produit) {

        return produitRepository.save(produit);
    }

    @Override
    public List<Produit> findAll() {
        return produitRepository.findAll();
    }

    @Override
    public Produit update(Produit produit) {
        Optional<Produit> prd =produitRepository.findById(produit.getId());
        if (prd.isPresent()) {
            produitRepository.save(produit);
            return produit;
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        produitRepository.deleteById(id);
    }

    @Override
    public Produit findById(Long id) {
        Optional<Produit> produit = produitRepository.findById(id);
        if (produit.isPresent()) {
            return  produit.get();
        }
        else {
            return null;
        }
    }

    @Override
    public Produit findByStatus() {
        return null;
    }
}
