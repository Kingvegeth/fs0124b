package it.epicode;

import it.epicode.enums.Category;

public class Product {

    private Long id;
    private String name;
    private Category category;
    private Double price;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public Double getPrice() {
        return price;
    }

    public Product(Long id, String name, Category category, Double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }
}
