package com.curtiscooley.rose

import com.gildedrose.Item

class Sulfras(item: Item) : StoreItem {
    override val name = item.name
    override var sellIn = item.sellIn
    override var quality = item.quality
    override fun update() {
    }
}
