package org.mutationtesting.demo;

import java.util.List;

public class Demo {
    static String fizzBuzz(Integer n) {
        if (n % 15 == 0) return "FizzBuzz";
        else if (n % 5 == 0) return "Buzz";
        else if (n % 3 == 0) return "Fizz";
        else return n.toString();
    }

    /**
     * Take a list of item prices and calculate the bill :
     * - if total is higher than 50, apply 10% overall discount
     * - if more than 5 items, apply 100% discount on cheapest one
     * - if many discount apply, use the higher one
     */
    static Double getPrice(List<Double> prices) {
        Double total = sum(prices);
        Double discount = 0.0;
        if (total >= 50) {
            discount = total * 0.1;
        }
        if (prices.size() >= 5) {
            Double minPrice = min(prices);
            if (minPrice > discount) {
                discount = minPrice;
            }
        }
        return total - discount;
    }

    private static Double sum(List<Double> values) {
        Double result = 0.0;
        for (Double value : values) {
            result = result + value;
        }
        return result;
    }

    private static Double min(List<Double> values) {
        Double result = null;
        for (Double value : values) {
            if (result == null || result > value) {
                result = value;
            }
        }
        return result;
    }
}
