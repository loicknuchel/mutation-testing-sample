package org.mutationtesting.demo.gildedrose

import org.scalatest.{FunSpec, Matchers}

class GildedRoseSpec extends FunSpec with Matchers {
  describe("GildedRose") {
    describe("Implement spec") {
      it("At the end of each day our system lowers both values for every item") {
        val sword = new Item("Sword", 10, 10)
        val gr = new GildedRose(Array(sword))
        gr.updateQuality()
        sword.sellIn shouldBe 9
        sword.quality shouldBe 9
      } // coverage: 26%, mutation coverage: 19%

      it("Once the sell by date has passed, Quality degrades twice as fast") {
        val sword = new Item("Sword", 0, 10)
        val gr = new GildedRose(Array(sword))
        gr.updateQuality()
        sword.sellIn shouldBe -1
        sword.quality shouldBe 8
      } // coverage: 42%, mutation coverage: 31%

      it("The Quality of an item is never negative") {
        val sword = new Item("Sword", 10, 0)
        val gr = new GildedRose(Array(sword))
        gr.updateQuality()
        sword.sellIn shouldBe 9
        sword.quality shouldBe 0
      } // coverage: 44%, mutation coverage: 33%

      it("'Aged Brie' actually increases in Quality the older it gets") {
        val AgedBrie = new Item("Aged Brie", 10, 10)
        val gr = new GildedRose(Array(AgedBrie))
        gr.updateQuality()
        AgedBrie.sellIn shouldBe 9
        AgedBrie.quality shouldBe 11
      } // coverage: 53%, mutation coverage: 44%

      it("The Quality of an item is never more than 50") {
        val AgedBrie = new Item("Aged Brie", 10, 50)
        val gr = new GildedRose(Array(AgedBrie))
        gr.updateQuality()
        AgedBrie.sellIn shouldBe 9
        AgedBrie.quality shouldBe 50
      } // coverage: 55%, mutation coverage: 46%

      it("'Sulfuras', being a legendary item, never has to be sold or decreases in Quality") {
        val Sulfuras = new Item("Sulfuras, Hand of Ragnaros", 10, 80)
        val gr = new GildedRose(Array(Sulfuras))
        gr.updateQuality()
        Sulfuras.sellIn shouldBe 10
        Sulfuras.quality shouldBe 80
      } // coverage: 60%, mutation coverage: 49%

      it("'Backstage passes', like aged brie, increases in Quality as its SellIn value approaches") {
        val BackstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 20, 10)
        val gr = new GildedRose(Array(BackstagePasses))
        gr.updateQuality()
        BackstagePasses.sellIn shouldBe 19
        BackstagePasses.quality shouldBe 11
      } // coverage: 67%, mutation coverage: 55%

      it("'Backstage passes' quality increases by 2 when there are 10 days or less") {
        val BackstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10)
        val gr = new GildedRose(Array(BackstagePasses))
        gr.updateQuality()
        BackstagePasses.sellIn shouldBe 9
        BackstagePasses.quality shouldBe 12
      } // coverage: 73%, mutation coverage: 64%

      it("'Backstage passes' quality increases by 3 when there are 5 days or less") {
        val BackstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10)
        val gr = new GildedRose(Array(BackstagePasses))
        gr.updateQuality()
        BackstagePasses.sellIn shouldBe 4
        BackstagePasses.quality shouldBe 13
      } // coverage: 79%, mutation coverage: 72%

      it("'Backstage passes' quality drops to 0 after the concert") {
        val BackstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10)
        val gr = new GildedRose(Array(BackstagePasses))
        gr.updateQuality()
        BackstagePasses.sellIn shouldBe -1
        BackstagePasses.quality shouldBe 0
      } // coverage: 83%, mutation coverage: 77%
    }

    describe("Get 100% coverage") {
      // TODO
    }

    describe("Get 100% mutation coverage") {
      // TODO
    }
  }
}
