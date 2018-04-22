package org.mutationtesting.demo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class CartTest {
    @Test
    public void Cart_has_no_assert() {
        new Cart(3).add("shoes");
    }

    @Test
    public void Cart_has_irrelevant_assert() {
        assertFalse(new Cart(3).add("shoes"));
    }

    @Test
    public void Cart_asserts_few_things() {
        Cart cart = new Cart(3);
        cart.add("shoes");
        assertEquals(1, cart.items.size());
    }
}
