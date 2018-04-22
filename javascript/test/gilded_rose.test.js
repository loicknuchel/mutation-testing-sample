const gildedRose = require("../src/gilded_rose");

test("At the end of each day our system lowers both values for every item", () => {
    const sword = new gildedRose.Item("Sword", 10, 10);
    const shop = new gildedRose.Shop([sword]);
    shop.updateQuality();
    expect(sword.sellIn).toBe(9);
    expect(sword.quality).toBe(9);
}); // coverage: 45%, mutation coverage: 25%

test("Once the sell by date has passed, Quality degrades twice as fast", () => {
    const sword = new gildedRose.Item("Sword", 0, 10);
    const shop = new gildedRose.Shop([sword]);
    shop.updateQuality();
    expect(sword.sellIn).toBe(-1);
    expect(sword.quality).toBe(8);
}); // coverage: 61%, mutation coverage: 39%

test("The Quality of an item is never negative", () => {
    const sword = new gildedRose.Item("Sword", 10, 0);
    const shop = new gildedRose.Shop([sword]);
    shop.updateQuality();
    expect(sword.sellIn).toBe(9);
    expect(sword.quality).toBe(0);
}); // coverage: 61%, mutation coverage: 41%

test("'Aged Brie' actually increases in Quality the older it gets", () => {
    const AgedBrie = new gildedRose.Item("Aged Brie", 10, 10);
    const shop = new gildedRose.Shop([AgedBrie]);
    shop.updateQuality();
    expect(AgedBrie.sellIn).toBe(9);
    expect(AgedBrie.quality).toBe(11);
}); // coverage: 71%, mutation coverage: 51%

test("The Quality of an item is never more than 50", () => {
    const AgedBrie = new gildedRose.Item("Aged Brie", 10, 50);
    const shop = new gildedRose.Shop([AgedBrie]);
    shop.updateQuality();
    expect(AgedBrie.sellIn).toBe(9);
    expect(AgedBrie.quality).toBe(50);
}); // coverage: 71%, mutation coverage: 53%

test("'Sulfuras', being a legendary item, never has to be sold or decreases in Quality", () => {
    const Sulfuras = new gildedRose.Item("Sulfuras, Hand of Ragnaros", 10, 80);
    const shop = new gildedRose.Shop([Sulfuras]);
    shop.updateQuality();
    expect(Sulfuras.sellIn).toBe(10);
    expect(Sulfuras.quality).toBe(80);
}); // coverage: 71%, mutation coverage: 57%

test("'Backstage passes', like aged brie, increases in Quality as its SellIn value approaches", () => {
    const BackstagePasses = new gildedRose.Item("Backstage passes to a TAFKAL80ETC concert", 20, 10);
    const shop = new gildedRose.Shop([BackstagePasses]);
    shop.updateQuality();
    expect(BackstagePasses.sellIn).toBe(19);
    expect(BackstagePasses.quality).toBe(11);
}); // coverage: 77%, mutation coverage: 62%

test("'Backstage passes' quality increases by 2 when there are 10 days or less", () => {
    const BackstagePasses = new gildedRose.Item("Backstage passes to a TAFKAL80ETC concert", 10, 10);
    const shop = new gildedRose.Shop([BackstagePasses]);
    shop.updateQuality();
    expect(BackstagePasses.sellIn).toBe(9);
    expect(BackstagePasses.quality).toBe(12);
}); // coverage: 84%, mutation coverage: 71%

test("'Backstage passes' quality increases by 3 when there are 5 days or less", () => {
    const BackstagePasses = new gildedRose.Item("Backstage passes to a TAFKAL80ETC concert", 5, 10);
    const shop = new gildedRose.Shop([BackstagePasses]);
    shop.updateQuality();
    expect(BackstagePasses.sellIn).toBe(4);
    expect(BackstagePasses.quality).toBe(13);
}); // coverage: 90%, mutation coverage: 76%

test("'Backstage passes' quality drops to 0 after the concert", () => {
    const BackstagePasses = new gildedRose.Item("Backstage passes to a TAFKAL80ETC concert", 0, 10);
    const shop = new gildedRose.Shop([BackstagePasses]);
    shop.updateQuality();
    expect(BackstagePasses.sellIn).toBe(-1);
    expect(BackstagePasses.quality).toBe(0);
}); // coverage: 94%, mutation coverage: 80%
