package com.curtiscooley.rose

import com.gildedrose.Item

open class StandardItem(item: Item, val rate: Int = 1) : StoreItem {
    override var sellIn: Int = item.sellIn
    override var quality: Int = item.quality

    override fun update() {
        if (quality > 0) {
            quality -= rate
        }
        sellIn -= 1
        if (sellIn < 0) {
            if (quality > 0) {
                quality -= rate
            }
        }
    }
}
