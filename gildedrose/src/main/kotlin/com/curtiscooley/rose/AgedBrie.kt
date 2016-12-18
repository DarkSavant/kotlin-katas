package com.curtiscooley.rose

import com.gildedrose.Item

class AgedBrie(item: Item) : StoreItem {
    override var sellIn = item.sellIn
    override var quality = item.quality

    override fun update() {
        if (quality < 50) quality++
        if (sellIn < 0) quality++
    }
}