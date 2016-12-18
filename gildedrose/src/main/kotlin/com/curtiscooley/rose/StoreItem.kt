package com.curtiscooley.rose

interface StoreItem {
    var sellIn: Int
    var quality: Int
    fun update(): Unit
}
