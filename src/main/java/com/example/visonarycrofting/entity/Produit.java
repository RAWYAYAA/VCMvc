package com.example.visonarycrofting.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String productName;
    @Column
    private Double productPrice;
    @Column
    private String category;
    @Column
    private String description;
    @Column
    private Integer quantity;
    @ManyToOne
    private Stock stock;

    @OneToOne(mappedBy = "produit")
    private CommandeItem commandeItem;


}