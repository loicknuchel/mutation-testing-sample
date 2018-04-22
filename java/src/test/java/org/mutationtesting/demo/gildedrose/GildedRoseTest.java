package org.mutationtesting.demo.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {
    /**
     * Test spec
     */
    @Test
    public void At_the_end_of_each_day_our_system_lowers_both_values_for_every_item() {
        Item sword = new Item("Sword", 10, 10);
        GildedRose gr = new GildedRose(new Item[]{sword});
        gr.updateQuality();
        assertEquals(9, sword.sellIn);
        assertEquals(9, sword.quality);
    } // coverage: 50%, mutation coverage: 29%

    @Test
    public void Once_the_sell_by_date_has_passed_Quality_degrades_twice_as_fast() {
        Item sword = new Item("Sword", 0, 10);
        GildedRose gr = new GildedRose(new Item[]{sword});
        gr.updateQuality();
        assertEquals(-1, sword.sellIn);
        assertEquals(8, sword.quality);
    } // coverage: 64%, mutation coverage: 42%

    @Test
    public void The_Quality_of_an_item_is_never_negative() {
        Item sword = new Item("Sword", 10, 0);
        GildedRose gr = new GildedRose(new Item[]{sword});
        gr.updateQuality();
        assertEquals(9, sword.sellIn);
        assertEquals(0, sword.quality);
    } // coverage: 64%, mutation coverage: 45%

    @Test
    public void Aged_Brie_actually_increases_in_Quality_the_older_it_gets() {
        Item AgedBrie = new Item("Aged Brie", 10, 10);
        GildedRose gr = new GildedRose(new Item[]{AgedBrie});
        gr.updateQuality();
        assertEquals(9, AgedBrie.sellIn);
        assertEquals(11, AgedBrie.quality);
    } // coverage: 72%, mutation coverage: 53%

    @Test
    public void The_Quality_of_an_item_is_never_more_than_50() {
        Item AgedBrie = new Item("Aged Brie", 10, 50);
        GildedRose gr = new GildedRose(new Item[]{AgedBrie});
        gr.updateQuality();
        assertEquals(9, AgedBrie.sellIn);
        assertEquals(50, AgedBrie.quality);
    } // coverage: 72%, mutation coverage: 55%

    @Test
    public void Sulfuras_being_a_legendary_item_never_has_to_be_sold_or_decreases_in_Quality() {
        Item Sulfuras = new Item("Sulfuras, Hand of Ragnaros", 10, 80);
        GildedRose gr = new GildedRose(new Item[]{Sulfuras});
        gr.updateQuality();
        assertEquals(10, Sulfuras.sellIn);
        assertEquals(80, Sulfuras.quality);
    } // coverage: 72%, mutation coverage: 55%

    @Test
    public void Backstage_passes_like_aged_brie_increases_in_Quality_as_its_SellIn_value_approaches() {
        Item BackstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 20, 10);
        GildedRose gr = new GildedRose(new Item[]{BackstagePasses});
        gr.updateQuality();
        assertEquals(19, BackstagePasses.sellIn);
        assertEquals(11, BackstagePasses.quality);
    } // coverage: 78%, mutation coverage: 61%

    @Test
    public void Backstage_passes_quality_increases_by_2_when_there_are_10_days_or_less() {
        Item BackstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10);
        GildedRose gr = new GildedRose(new Item[]{BackstagePasses});
        gr.updateQuality();
        assertEquals(9, BackstagePasses.sellIn);
        assertEquals(12, BackstagePasses.quality);
    } // coverage: 83%, mutation coverage: 66%

    @Test
    public void Backstage_passes_quality_increases_by_3_when_there_are_5_days_or_less() {
        Item BackstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10);
        GildedRose gr = new GildedRose(new Item[]{BackstagePasses});
        gr.updateQuality();
        assertEquals(4, BackstagePasses.sellIn);
        assertEquals(13, BackstagePasses.quality);
    } // coverage: 89%, mutation coverage: 71%

    @Test
    public void Backstage_passes_quality_drops_to_0_after_the_concert() {
        Item BackstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10);
        GildedRose gr = new GildedRose(new Item[]{BackstagePasses});
        gr.updateQuality();
        assertEquals(-1, BackstagePasses.sellIn);
        assertEquals(0, BackstagePasses.quality);
    } // coverage: 92%, mutation coverage: 74%
}
