package com.example.shoplist.ui.shoppinglist

import com.example.shoplist.data.db.entities.ShopItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ShopItem)
}