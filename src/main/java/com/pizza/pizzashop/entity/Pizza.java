package com.pizza.pizzashop.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Pizza")
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String size;
    private double price;

    public Pizza() {}

    public Pizza(String name, String size, double price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }

    public long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}
