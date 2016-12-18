package com.curtiscooley.rose

import com.gildedrose.GildedRose
import com.gildedrose.Item
import io.kotlintest.specs.FlatSpec

class GildedRoseTest : FlatSpec() {
    init {
        "Sulfras" should "never age" {
            val items = arrayOf<StoreItem>(Sulfras(Item(name = "Sulfuras, Hand of Ragnaros", sellIn = 2, quality = 4)))
            val app = GildedRose(items)
            app.updateQuality()
            items[0].quality shouldBe 4
            items[0].sellIn shouldBe 2
        }

        "Non-expired regular items" should "degrade as expected" {
            val items = arrayOf<StoreItem>(StandardItem(Item(name = "Regular item", sellIn = 2, quality = 5)),
                    StandardItem(Item("Regular item", sellIn = 0, quality = 4)))
            val app = GildedRose(items)
            app.updateQuality()
            items[0].quality shouldBe 4
            items[0].sellIn shouldBe 1
            items[1].quality shouldBe 2
            items[1].sellIn shouldBe -1
        }

        "conjured items" should "degrade as twice as fast as regular items" {
            val items = arrayOf<StoreItem>(ConjuredItem(Item(name = "Conjured item", sellIn = 2, quality = 5)),
                    ConjuredItem(Item("Conjured item", sellIn = 0, quality = 4)))
            val app = GildedRose(items)
            app.updateQuality()
            items[0].quality shouldBe 3
            items[0].sellIn shouldBe 1
            items[1].quality shouldBe 0
            items[1].sellIn shouldBe -1
        }

        "Backstage concert passes" should "age as expected" {
            val itemName = "Backstage passes to a TAFKAL80ETC concert"
            val items = arrayOf<StoreItem>(BackStagePass(Item(name = itemName, sellIn = 11, quality = 5)),
                    BackStagePass(Item(itemName, sellIn = 10, quality = 4)),
                    BackStagePass(Item(itemName, 6, 4)),
                    BackStagePass(Item(itemName, 5, 7)),
                    BackStagePass(Item(itemName, 5, 50)),
                    BackStagePass(Item(itemName, -1, 40)))
            val app = GildedRose(items)
            app.updateQuality()
            items[0].quality shouldBe 6
            items[1].quality shouldBe 6
            items[2].quality shouldBe 6
            items[3].quality shouldBe 10
            items[4].quality shouldBe 50
            items[5].quality shouldBe 0
        }

        "Brie" should "increase in quality" {
            val itemName = "Aged Brie"
            val items = arrayOf<StoreItem>(AgedBrie(Item(name = itemName, sellIn = 10, quality = 5)),
                    AgedBrie(Item(name = itemName, sellIn = 10, quality = 50)),
                    AgedBrie(Item(name = itemName, sellIn = -1, quality = 10)))
            val app = GildedRose(items)
            app.updateQuality()
            items[0].quality shouldBe 6
            items[1].quality shouldBe 50
            items[2].quality shouldBe 12
        }
    }
}

