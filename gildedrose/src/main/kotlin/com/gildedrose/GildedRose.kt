package com.gildedrose

import com.curtiscooley.rose.*

class GildedRose(var items: Array<StoreItem>) {
    fun updateQuality() {
        items.forEach(StoreItem::update)
    }
}

