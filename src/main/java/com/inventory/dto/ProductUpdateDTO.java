package com.inventory.dto;

public class ProductUpdateDTO {
    private String name;
    private int price;
    private String category;
    private int quantity;
    private String status;

    public ProductUpdateDTO() {
    }

    public ProductUpdateDTO(String name, int price, String category, int quantity, String status) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

