package com.example.importproduct.service.dto;

import java.math.BigDecimal;

public class Show {
    private int id;
    private String product;
    private int quantity;
    private BigDecimal amount;

    public Show() {
    }

    public Show(int id, String product, int quantity, BigDecimal amount) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
