package com.example.visonarycrofting.Repository;

import com.example.visonarycrofting.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StockRepository extends JpaRepository<Stock,Long> {
}
