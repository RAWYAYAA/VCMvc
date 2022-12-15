package com.example.visonarycrofting.controller;

import com.example.visonarycrofting.entity.Commande;
import com.example.visonarycrofting.entity.CommandeItem;
import com.example.visonarycrofting.entity.Produit;
import com.example.visonarycrofting.service.Implementations.CommandeItemService;
import com.example.visonarycrofting.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Controller
public class CommandeItemController {
    @Qualifier("commandeItemService")
    @Autowired
    ServiceInterface commandeItemService;

    @Qualifier("produitService")
    @Autowired
    ServiceInterface produitService;

    @Qualifier("commandeService")
    @Autowired
    ServiceInterface commandeService;

    @PostMapping(path = "/addCommandItem")
    public String addCommandItem(Long idProduct,Integer itemQuantity){
        Produit produit = produitService.findById(idProduct);
        Commande commande = new Commande();
        if ( commandeService.findByStatus() == null) {
            commandeService.save(commande);
        }else{
            commande = (Commande) commandeService.findByStatus();
        }
        CommandeItem commandeItem = new CommandeItem();
        commandeItem.setReferenceOfItem(UUID.randomUUID().toString());
        commandeItem.setItemQuantity(itemQuantity);
        commandeItem.setProduit(produit);
        commandeItem.setItemUnitPrice(produit.getProductPrice()*itemQuantity);
        commandeItem.setCommande(commande);
        commandeItemService.save(commandeItem);
        return "redirect:/product";
    }

    @GetMapping(path = "/panier")
    public String panier(Model model){
        Commande commande = new Commande();
        if ( commandeService.findByStatus() == null) {
            commandeService.save(commande);
        }else{
            commande = (Commande) commandeService.findByStatus();
        }
        model.addAttribute("commandeItems",commande.getCommandeItem());
        return "panier";
    }
}
