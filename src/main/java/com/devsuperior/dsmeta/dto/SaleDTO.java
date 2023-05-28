package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class SaleDTO implements Serializable {
    private static final long serialVersionUID=1L;
    private Long id;
    private Double amount;
    private LocalDate date;
    private String sellerName;

    public SaleDTO() {

    }
    public SaleDTO(Long id, Double amount, LocalDate date, String sellerName) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.sellerName = sellerName;
    }

    public SaleDTO(Sale entity) {
      id= entity.getId();
      amount= entity.getAmount();
      date=entity.getDate();
      sellerName= entity.getSeller().getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SaleDTO)) return false;
        SaleDTO saleDTO = (SaleDTO) o;
        return Objects.equals(id, saleDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
