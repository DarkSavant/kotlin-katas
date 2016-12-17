package com.curtiscooley.rose

interface StoreItem {
    val name: String
    var sellIn: Int
    var quality: Int
    fun update(): Unit
}
