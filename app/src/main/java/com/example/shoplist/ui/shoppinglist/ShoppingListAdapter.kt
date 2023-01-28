package com.example.shoplist.ui.shoppinglist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoplist.data.db.entities.ShopItem
import com.example.shoplist.databinding.ShoppingItemBinding

class ShoppingListAdapter(
    var items: List<ShopItem>,
    private val viewModel: ShoppingViewModel
) : RecyclerView.Adapter<ShoppingListAdapter.ShoppingViewHolder>() {
    inner class ShoppingViewHolder(val binding: ShoppingItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val binding =
            ShoppingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShoppingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val currentShopItem = items[position]
        with(holder) {
            with(binding) {
                tvName.text = currentShopItem.name
                tvAmount.text = "${currentShopItem.amount}"
                ivDelete.setOnClickListener { viewModel.delete(currentShopItem) }
                ivMinus.setOnClickListener {
                    if (currentShopItem.amount > 0)
                        currentShopItem.amount--
                    viewModel.upsert(currentShopItem)
                }
                ivPlus.setOnClickListener {
                    currentShopItem.amount++
                    viewModel.upsert(currentShopItem)
                }
            }
        }
    }

    override fun getItemCount() = items.size
}