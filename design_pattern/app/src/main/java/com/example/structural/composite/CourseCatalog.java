package com.example.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class CourseCatalog extends CatalogComponent {
    private List<CatalogComponent> items = new ArrayList<CatalogComponent>();
    private String name;

    public CourseCatalog(List<CatalogComponent> items, String name) {
        this.items = items;
        this.name = name;
    }

    public CourseCatalog(String name) {
        this.name = name;
    }

    @Override
    public String getName(CatalogComponent catalogComponent) {
        return this.name;
    }

    @Override
    public void add(CatalogComponent catalogComponent) {
        items.add(catalogComponent);
    }

    @Override
    public void remove(CatalogComponent catalogComponent) {
        items.add(catalogComponent);
    }

    @Override
    public void print() {
        for (CatalogComponent catalogComponent : items) {
            catalogComponent.print();
        }
    }
}
