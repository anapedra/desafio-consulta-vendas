package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.entities.Seller;

import java.io.Serializable;
import java.util.Objects;

public class SellerDTO implements Serializable {
    private static final long serialVersionUID=1L;

    private Long id;
    private String name;
    private String email;
    private String phone;

    public SellerDTO() {

    }

    public SellerDTO(Long id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public SellerDTO(Seller entity) {
     id=entity.getId();
     name=entity.getName();
     email= entity.getEmail();
     phone= entity.getPhone();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SellerDTO)) return false;
        SellerDTO sellerDTO = (SellerDTO) o;
        return Objects.equals(getId(), sellerDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
