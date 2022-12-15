package com.example.visonarycrofting.service;
import com.example.visonarycrofting.entity.Produit;

import java.util.List;

public interface ServiceInterface<T> {
    T save(T t);
    List<T> findAll();
    T update(T t);
    void  delete(Long id);
    Produit findById(Long id);
    T findByStatus();
}
