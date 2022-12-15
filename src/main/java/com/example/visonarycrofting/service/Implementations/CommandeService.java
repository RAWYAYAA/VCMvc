package com.example.visonarycrofting.service.Implementations;

import com.example.visonarycrofting.Repository.CommandeRepository;
import com.example.visonarycrofting.entity.Commande;
import com.example.visonarycrofting.entity.Produit;
import com.example.visonarycrofting.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CommandeService implements ServiceInterface<Commande>{

    Commande command = new Commande();
    @Autowired
    private CommandeRepository commandRepository;

    @Override
    public Commande save(Commande commande) {
        //boolean CommandIsValid = validateCommand(command);
            Commande com = commandRepository.save(commande);
            return commandRepository.findByReference(com.getReference());

    }



    @Override
    public List<Commande> findAll() {
        return null;
    }

    @Override
    public Commande update(Commande commande) {
        commandRepository.save(commande);
        return commande;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Produit findById(Long id) {

        return null;
    }

    @Override
    public Commande findByStatus() {
        Optional<Commande> commande= commandRepository.findByStatusCommand(Commande.StatusCommand.EN_COURS);
        if (commande.isPresent()) {
            return commande.get();
        }
        return null;
    }

    private boolean validateCommand(Commande command){
        if (!Objects.isNull(command) || !command.equals(new Commande())) {
            if (command.getReference().isEmpty()) {
                return false;
            }
            /*if (command.getCommandDate().isEmpty() || command.getCommandDate() == null) {
                return false;
            }*/
            if (command.getCommandTotalPrice().isNaN() || command.getCommandTotalPrice() <= 0){
                return false;
            }
            return true;
        }else return false;
    }

}
