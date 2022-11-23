package com.ecommerce.wines.DTOS;

import com.ecommerce.wines.models.Product;
import com.ecommerce.wines.models.Variety;

public class ProductDTO {

    private long id;

    private String category;

    private String name;

    private String description;

    private int stock;

    private double price;

    private double discount;

    private String img;

    private Variety variety;

    private String tastingNote;

    private String temperature;

    public ProductDTO() {
    }

    public ProductDTO(Product product) {
        this.category = product.getCategory();
        this.name = product.getName();
        this.description = product.getDescription();
        this.stock = product.getStock();
        this.price = product.getPrice();
        this.discount = product.getDiscount();
        this.img = product.getImg();
        this.variety = product.getVariety();
        this.tastingNote = product.getTastingNote();
        this.temperature = product.getTemperature();
    }



    public long getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Variety getVariety() {
        return variety;
    }

    public void setVariety(Variety variety) {
        this.variety = variety;
    }

    public String getTastingNote() {
        return tastingNote;
    }

    public void setTastingNote(String tastingNote) {
        this.tastingNote = tastingNote;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
}
