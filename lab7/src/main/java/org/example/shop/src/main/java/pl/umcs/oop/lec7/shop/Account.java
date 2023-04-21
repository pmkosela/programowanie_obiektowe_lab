package org.example.shop.src.main.java.pl.umcs.oop.lec7.shop;

public class Account {
    private String name;

    public Account(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public <T extends Product> Cart<T> createCart() {
        return new Cart(this);
    }
}
