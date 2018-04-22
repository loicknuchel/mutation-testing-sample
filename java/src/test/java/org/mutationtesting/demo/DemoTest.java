package org.mutationtesting.demo;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class DemoTest {
    @Test
    public void fizzBuzz_should_return_FizzBuzz_on_zero() {
        assertEquals("FizzBuzz", Demo.fizzBuzz(0));
    }

    @Test
    public void fizzBuzz_should_return_Fizz_on_three() {
        assertEquals("Fizz", Demo.fizzBuzz(3));
    }

    @Test
    public void fizzBuzz_should_return_4_on_four() {
        assertEquals("4", Demo.fizzBuzz(4));
    }

    @Test
    public void fizzBuzz_should_return_Buzz_on_five() {
        assertEquals("Buzz", Demo.fizzBuzz(5));
    }


    @Test
    public void getPrice_should_be_normal_price_with_few_and_cheap_items() {
        assertEquals(24.0, Demo.getPrice(Arrays.asList(4.0, 7.0, 1.0, 12.0)), 0.001);
    }

    @Test
    public void getPrice_should_be_get_10pc_discound_on_expensive_items() {
        assertEquals(54.0, Demo.getPrice(Arrays.asList(10.0, 20.0, 30.0)), 0.001);
    }

    @Test
    public void getPrice_should_be_get_one_free_item_when_buy_many() {
        assertEquals(22.0, Demo.getPrice(Arrays.asList(3.0, 5.0, 2.0, 8.0, 1.0, 4.0)), 0.001);
    }

    @Test
    public void getPrice_should_should_test_boundary_conditions() {
        assertEquals(45.0, Demo.getPrice(Arrays.asList(5.0, 10.0, 15.0, 20.0)), 0.001); // 50 total value boundary
        assertEquals(43.0, Demo.getPrice(Arrays.asList(7.0, 8.0, 15.0, 10.0, 10.0)), 0.001); // 5 item boundary
    }
}
