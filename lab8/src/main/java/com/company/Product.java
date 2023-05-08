package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class Product {
    protected String name;
    public static List<Product> products = new ArrayList<>();

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double getPrice(int year, int month);

    public static void clearProducts() {
        products.clear();
    }

    public static void addProducts(Function<Path, Product> function, Path path) {
        try {
            List<Product> newProducts = Files.list(path)
                    .map(csvFilePath -> function.apply(csvFilePath))
                    .toList();
            products.addAll(newProducts);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Product getProduct(String prefix) throws AmbigiousProductException, IndexOutOfBoundsException {
        List<Product> result = products.stream()
                .filter(product -> product.getName().startsWith(prefix))
                .toList();
        switch(result.size()) {
            case 0: throw new IndexOutOfBoundsException(prefix);
            case 1: return result.get(0);
            default: throw new AmbigiousProductException(result.stream()
                    .map(product -> product.getName())
                    .collect(Collectors.toList()));
        }
    }

    public static int priceIndex(int year, int month) {
        if(year<2010 || year>2022 || (year==2022 && month>3) || month<1 || month>12)
            throw new IndexOutOfBoundsException();
        return (year-2010) * 12 + (month-1);
    }
}
