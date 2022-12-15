package com.example.visonarycrofting.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@NotNull
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String email;
    @Column
    @Size(min=10,max=12)
    private String phone;
    @Column
    @Size(min=8)
    private String password;
    @OneToMany(mappedBy = "vendor")
    private List<CallOffer> callOffers;
}


