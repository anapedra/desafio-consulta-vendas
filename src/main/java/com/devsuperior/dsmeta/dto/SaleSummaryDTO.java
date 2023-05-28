package com.devsuperior.dsmeta.dto;
import com.devsuperior.dsmeta.entities.Sale;

import java.io.Serializable;
import java.time.LocalDate;

public class SaleSummaryDTO implements Serializable {
    private static final long serialVersionUID=1L;

    private Double amount;
    private String sellerName;
    private double total;

    public SaleSummaryDTO(String sellerName, double total) {
        this.sellerName = sellerName;
        this.total = total;
    }

    public SaleSummaryDTO() {

    }

    public SaleSummaryDTO(Sale entity) {
        sellerName= entity.getSeller().getName();
        total=entity.getAmount();
    }



    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
