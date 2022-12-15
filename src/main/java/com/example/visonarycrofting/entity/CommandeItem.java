package com.example.visonarycrofting.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class CommandeItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String referenceOfItem;
    private Integer itemQuantity;
    private Double itemUnitPrice;

    @OneToOne
    private Produit produit;

    @ManyToOne
    private Commande commande;
}
