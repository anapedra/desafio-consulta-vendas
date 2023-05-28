package com.devsuperior.dsmeta.repositories;

import com.devsuperior.dsmeta.entities.Seller;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmeta.entities.Sale;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {


    @Query("SELECT obj FROM Sale obj WHERE " +
            "obj.date BETWEEN :min AND :max and " +
      "(LOWER(obj.seller.name) LIKE LOWER(CONCAT('%',:name,'%'))) ")
    Page<Sale> findAllSale(LocalDate min, LocalDate max,String name , Pageable pageable);
    @Query("SELECT obj FROM Sale obj JOIN FETCH obj.seller WHERE " +
            "obj IN :sales ")
    List<Sale> findAllSales(List<Sale>sales);




    @Query("SELECT obj FROM Sale obj WHERE " +
            "obj.date BETWEEN :min AND :max ")
    List<Sale> findAllSummary(LocalDate min, LocalDate max);



}
