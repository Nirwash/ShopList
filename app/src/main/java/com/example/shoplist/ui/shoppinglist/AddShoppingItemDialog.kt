package com.example.shoplist.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.shoplist.data.db.entities.ShopItem
import com.example.shoplist.databinding.DialogAddShoppingItemBinding

class AddShoppingItemDialog(context: Context, private val addDialogListener: AddDialogListener) :
    AppCompatDialog(context) {
    private lateinit var binding: DialogAddShoppingItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogAddShoppingItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            tvAdd.setOnClickListener {
                val name = etName.text.toString()
                val amount = etAmount.text.toString()
                if (name.isEmpty() || amount.isEmpty()) {
                    Toast.makeText(context, "Please enter all the information", Toast.LENGTH_SHORT)
                        .show()
                    return@setOnClickListener
                }

                val item = ShopItem(name, amount.toInt())
                addDialogListener.onAddButtonClicked(item)
                dismiss()
            }
            tvCancel.setOnClickListener { cancel() }
        }

    }
}