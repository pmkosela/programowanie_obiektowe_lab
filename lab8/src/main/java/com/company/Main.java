package com.company;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        Product.addProducts(FoodProduct::fromCsv, Path.of("data/food"));
        Product.addProducts(NonFoodProduct::fromCsv, Path.of("data/nonfood"));

        try {
            Product p1 = Product.getProduct("Buraki");
            System.out.println(p1.getPrice(2012, 5));

            //Product p2 = Product.getProduct("Mięso"); // <- rzuca wyjątek AmbigiousProductException
            //Product p3 = Product.getProduct("Komputer"); // <- rzuca wyjątek IndexOutOfBoundsException

            Cart cart = new Cart();
            cart.addProduct(Product.getProduct("Benzyna"), 100);
            cart.addProduct(Product.getProduct("Jabłka"), 20);
            cart.addProduct(Product.getProduct("Kiełbasa"), 5);
            cart.addProduct(Product.getProduct("Wizyta u lekarza"), 2);
            cart.addProduct(Product.getProduct("Ziemniaki"), 5);
            System.out.println(cart.getInflation(2020,1, 2022, 3));
        } catch (AmbigiousProductException | IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}