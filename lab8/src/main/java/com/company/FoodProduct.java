package com.company;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class FoodProduct extends Product {
    private Map<String, Double[]> prices;

    private FoodProduct(String name,  Map<String, Double[]> prices) {
        super(name);
        this.prices = prices;
    }

    public static FoodProduct fromCsv(Path path) {
        String name;
        Map<String, Double[]> prices = new HashMap<>();
        try {
            Scanner scanner = new Scanner(path);
            name = scanner.nextLine();
            scanner.nextLine();

            while(scanner.hasNext()) {
                String lineData[] = scanner.nextLine().split(";");
                String provinceName = lineData[0];

                Double[] provincePrices = Arrays.stream(lineData)
                        .skip(1)
                        .map(value -> value.replace(",","."))
                        .map(Double::valueOf)
                        .toArray(Double[]::new);

                prices.put(provinceName, provincePrices);
            }
            scanner.close();

            return new FoodProduct(name, prices);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public double getPrice(int year, int month) {
        int index = priceIndex(year, month);
        double sum = 0;
        for(Double[] provincePrices : prices.values())
            sum += provincePrices[index];

        return sum/prices.size();
    }

    public double getPrice(int year, int month, String province) {
        if(prices.containsKey(province))
            return prices.get(province)[priceIndex(year, month)];
        else
            throw new NoSuchElementException(province);
    }
}
