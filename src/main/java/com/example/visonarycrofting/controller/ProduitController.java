package com.example.visonarycrofting.controller;



import com.example.visonarycrofting.Repository.ProduitRepository;
import com.example.visonarycrofting.Repository.StockRepository;
import com.example.visonarycrofting.entity.Produit;

import com.example.visonarycrofting.entity.Stock;
import com.example.visonarycrofting.service.Implementations.ProduitService;
import com.example.visonarycrofting.service.Implementations.StockService;
import com.example.visonarycrofting.service.ServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Controller
public class ProduitController {
    @Qualifier("produitService")
    @Autowired
    private ServiceInterface produitService;
    @Qualifier("stockService")
    @Autowired
    private ServiceInterface stockService;
   @GetMapping("/delete")
   public String deleteProduct(Long id){
       produitService.delete(id);
       return "redirect:/home";
   }
    @GetMapping("/home")
    public String home(Model model){
        List<Produit> produits = produitService.findAll();
        model.addAttribute("produits",produits);
        return "Produits";
    }
    @GetMapping("/Produits")
    @ResponseBody
    public  List<Produit> listProduits(){
        return    produitService.findAll();
    }
    @GetMapping("/formProduit")
    public String formProduit(Model model){
        List<Stock> stocks = stockService.findAll();
        model.addAttribute("stocks" ,stocks);
        model.addAttribute("produit",new Produit());
        return "formProduct";
    }
    @GetMapping("/product")
    public String getProduct(Model model){
        List<Produit> produits = produitService.findAll();
        model.addAttribute("produits",produits);
       return "ProductsCards";
    }
    @PostMapping(path = "/save")
    public String save(Model model, @Valid Produit produit, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "formProduct";
        produitService.save(produit);
        return "home";
    }
    @PostMapping(path = "/update")
    public String update(@Valid Produit produit){
       Produit prd = (Produit) produitService.update(produit);
       return "redirect:/home";
    }
    @GetMapping("/editProduit")
    public String editProduit(Model model,Long id){
        Produit produit=produitService.findById(id);
        if(produit==null) throw  new RuntimeException("Produit introuvable");
        model.addAttribute("produit",produit);
        return "editProduit";
    }
}
