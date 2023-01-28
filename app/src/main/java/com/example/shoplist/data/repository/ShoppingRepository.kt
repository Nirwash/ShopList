package com.example.shoplist.data.repository

import com.example.shoplist.data.db.ShoppingDatabase
import com.example.shoplist.data.db.entities.ShopItem

class ShoppingRepository(private val db: ShoppingDatabase) {

    suspend fun upsert(item: ShopItem) = db.getShoppingDao().upsert(item)
    suspend fun delete(item: ShopItem) = db.getShoppingDao().delete(item)
    fun getAllShopItems() = db.getShoppingDao().getAllShopItems()
}