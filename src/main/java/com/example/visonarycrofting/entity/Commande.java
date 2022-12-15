package com.example.visonarycrofting.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
public class Commande {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String reference;
        private LocalDate commandDate;
        private Double commandTotalPrice;
        //@ManyToOne
        //private Client client;
        private StatusCommand statusCommand;

        @OneToMany(mappedBy = "commande")
        private List<CommandeItem> commandeItem;

        public Commande() {
                this.reference= UUID.randomUUID().toString();
                this.statusCommand=StatusCommand.EN_COURS;
        }

        public enum StatusCommand {
                EN_COURS,
                COMMANDE
        }
}
