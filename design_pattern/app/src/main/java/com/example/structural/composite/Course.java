package com.example.structural.composite;

public class Course extends CatalogComponent {
    private String name;
    private double price;

    public Course(String name) {
        this.name = name;
    }

    @Override
    public double getPrice(CatalogComponent catalogComponent) {
        return this.price;
    }

    @Override
    public String getName(CatalogComponent catalogComponent) {
        return this.name;
    }

    @Override
    public void print() {
        System.out.println(price + name);
    }
}
