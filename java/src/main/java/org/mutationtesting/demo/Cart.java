package org.mutationtesting.demo;

import java.util.ArrayList;
import java.util.List;

class Cart {
    private final Integer size;
    List<String> items = new ArrayList<String>();

    Cart(Integer size) {
        this.size = size;
    }

    boolean add(String item) {
        System.out.println("item add: " + item);
        boolean exists = items.contains(item);
        if (items.size() < size) {
            items.add(item);
        }
        return exists;
    }
}
