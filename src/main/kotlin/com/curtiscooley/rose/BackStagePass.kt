package com.curtiscooley.rose

import com.gildedrose.Item

class BackStagePass(item: Item) : StoreItem {
    override val name: String = item.name
    override var quality: Int = item.quality
    override var sellIn: Int = item.sellIn

    override fun update() {
        if (quality < 50) {
            quality++
            if (sellIn < 11) {
                quality += 1
            }
            if (sellIn < 6) {
                quality += 1
            }
        }
        if (sellIn < 0) quality = 0
    }
}
