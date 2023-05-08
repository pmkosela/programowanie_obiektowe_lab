package com.company;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private static class MultipleProduct {
        public final Product product;
        public final int amount;

        public MultipleProduct(Product product, int amount) {
            this.product = product;
            this.amount = amount;
        }
    }

    private List<MultipleProduct> products = new ArrayList<>();

    public void addProduct(Product product, int amount)  {
        products.add(new MultipleProduct(product, amount));
    }

    public double getPrice(int year, int month) {
        double sum = 0;
        for(var multipleProduct : products)
            sum += multipleProduct.product.getPrice(year, month) * multipleProduct.amount;
        return sum;
    }

    public double getInflation(int year1, int month1, int year2, int month2) {
        double price1 = getPrice(year1, month1);
        double price2 = getPrice(year2, month2);

        int months = ((year2-year1) * 12 + (month2 - month1));

        return (price2 - price1) / price1 * 100 / months * 12;
    }
}
