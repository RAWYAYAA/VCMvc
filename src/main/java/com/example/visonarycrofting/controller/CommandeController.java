package com.example.visonarycrofting.controller;

import com.example.visonarycrofting.entity.Commande;
import com.example.visonarycrofting.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

@Controller
public class CommandeController {

    @Qualifier("commandeService")
    @Autowired
    ServiceInterface commandeService;

    @Qualifier("commandeItemService")
    @Autowired
    ServiceInterface commandeItemService;

    @GetMapping(path = "/index")
    public String addCommand(Model model){
        model.addAttribute("name","Oussama");
        return "formCommade";
    }

    @GetMapping("/saveCommande")
    public String saveCommande(Model model){
        Commande commande = (Commande) commandeService.findByStatus();
        if (!Objects.isNull(commande)) {
            if (commande.getCommandeItem().isEmpty() || commande.getCommandeItem()==null){
                model.addAttribute("message","vous ne pouvez pas effectuer une commande sans produit");
                return "redirect:/panier";
            }
            commande.setCommandDate(LocalDate.now());
            commande.setStatusCommand(Commande.StatusCommand.COMMANDE);
            AtomicReference<Double> totalPrice= new AtomicReference<>(0d);
            commande.getCommandeItem().stream().map(item->item.getItemUnitPrice()).forEach(p-> totalPrice.updateAndGet(v -> v + p));
            commande.setCommandTotalPrice(totalPrice.get());
            commandeService.update(commande);
            return "test";
        }else return "redirect:/panier";
    }

}
