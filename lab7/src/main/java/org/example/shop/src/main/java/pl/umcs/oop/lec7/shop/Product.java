package org.example.shop.src.main.java.pl.umcs.oop.lec7.shop;

import java.math.BigDecimal;

public class Product {
    protected String name;
    protected BigDecimal price;

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }
}
