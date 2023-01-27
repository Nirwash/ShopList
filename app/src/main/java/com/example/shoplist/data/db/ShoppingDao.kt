package com.example.shoplist.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.shoplist.data.db.entities.ShopItem

@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ShopItem)

    @Delete
    suspend fun delete(item: ShopItem)

    @Query("SELECT * FROM shop_items")
    fun getAllShopItems(): LiveData<List<ShopItem>>
}