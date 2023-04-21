package org.example.food_shop.src.main.java;

import pl.umcs.oop.lec7.shop.Product;

import java.math.BigDecimal;

public class FoodProduct extends Product {
    public Integer getEnergy() {
        return energy;
    }

    private Integer energy;

    public FoodProduct(String name, BigDecimal price, Integer energy) {
        super(name, price);
        this.energy = energy;
    }
}
