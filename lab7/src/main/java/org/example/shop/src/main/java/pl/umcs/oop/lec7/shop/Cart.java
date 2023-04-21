package org.example.shop.src.main.java.pl.umcs.oop.lec7.shop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cart<T extends Product> {
    protected List<T> products = new ArrayList<>();
    protected Account owner;

    public Cart(Account owner) {
        this.owner = owner;
    }

    public void add(T product) {
        products.add(product);
    }

    public BigDecimal value() {
        return products.stream()
                .map(product -> product.price)
                .reduce(new BigDecimal(0), BigDecimal::add);
    }
}
