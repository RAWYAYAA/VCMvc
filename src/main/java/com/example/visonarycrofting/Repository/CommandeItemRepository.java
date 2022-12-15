package com.example.visonarycrofting.Repository;

import com.example.visonarycrofting.entity.CommandeItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeItemRepository  extends JpaRepository<CommandeItem,Long> {
}
