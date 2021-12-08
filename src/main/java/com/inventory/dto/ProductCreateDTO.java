package com.inventory.dto;

import java.io.Serializable;

public class ProductCreateDTO implements Serializable {

    private static final long serialVersionUID = -7338047997792280285L;

    private String name;
    private int price;
    private String category;
    private int quantity;

    public ProductCreateDTO() {
    }

    public ProductCreateDTO(String name, int price, String category, int quantity) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.quantity = quantity;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
