package org.example.food_shop.src.main.java;

import org.example.shop.src.main.java.pl.umcs.oop.lec7.auth.AccountManager;
import org.example.shop.src.main.java.pl.umcs.oop.lec7.shop.Account;
import org.example.shop.src.main.java.pl.umcs.oop.lec7.shop.Cart;
import org.example.shop.src.main.java.pl.umcs.oop.lec7.shop.Product;

import java.math.BigDecimal;

public class Main {
    public static Account login(AccountManager accountManager, String name, String password) {
        if(accountManager.login("alice", "secret"))
            return new Account("alice");
        else
            throw new RuntimeException("Wrong credentials");
    }

    public static void main(String[] args) {
        AccountManager manager = new AccountManager();
        manager.register("alice", "secret");
        Account alice = login(manager, "alice", "secret");

        //Cart<FoodProduct> cart = alice.createCart();
        FoodCart cart = new FoodCart(alice);

        FoodProduct bread = new FoodProduct("bread",
                new BigDecimal(5), 250);
        FoodProduct butter = new FoodProduct("butter",
                new BigDecimal(8), 700);

        Product box = new Product("box",
                new BigDecimal(8));

        cart.add(bread);
        cart.add(butter);
        //cart.add(box);

        System.out.println(cart.value());
    }
}