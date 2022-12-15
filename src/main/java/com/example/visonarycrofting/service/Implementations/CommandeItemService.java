package com.example.visonarycrofting.service.Implementations;

import com.example.visonarycrofting.Repository.CommandeItemRepository;
import com.example.visonarycrofting.entity.CommandeItem;
import com.example.visonarycrofting.entity.Produit;
import com.example.visonarycrofting.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommandeItemService implements ServiceInterface<CommandeItem> {
    @Autowired
    CommandeItemRepository commandeItemRepository;
    @Override
    public CommandeItem save(CommandeItem commandeItem) {
        return commandeItemRepository.save(commandeItem);
    }
    @Override
    public List<CommandeItem> findAll() {
        return commandeItemRepository.findAll();
    }

    @Override
    public CommandeItem update(CommandeItem commandeItem) {
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
    public CommandeItem findByStatus() {
        return null;
    }
}
