package com.example.visonarycrofting.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client implements  java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String email;
        private String password;
        private String phone;
       // @OneToMany(mappedBy = "client")
       // private List<Commande> command;
}

