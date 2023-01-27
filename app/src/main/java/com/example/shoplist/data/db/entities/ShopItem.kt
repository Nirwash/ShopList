package com.example.shoplist.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shop_items")
data class ShopItem(
    @ColumnInfo(name = "item_name")
    val name: String,
    @ColumnInfo(name = "item_amount")
    val amount: Int = 0
) {
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
}
