package com.example.visonarycrofting.Repository;

import com.example.visonarycrofting.entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CommandeRepository extends JpaRepository<Commande,Long> {
    Commande findByReference(String ref);
    Optional<Commande> findByStatusCommand(Commande.StatusCommand statusCommand);
}
