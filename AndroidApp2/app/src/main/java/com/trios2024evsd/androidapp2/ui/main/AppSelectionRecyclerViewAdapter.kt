package com.trios2024evsd.androidapp2.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.trios2024evsd.androidapp2.databinding.AppSelectionViewHolderBinding
import com.trios2024evsd.androidapp2.models.OrderList

class AppSelectionRecyclerViewAdapter(private val orders:
    MutableList<OrderList>
):
RecyclerView.Adapter<AppSelectionViewHolder>(){

    val appTitles = arrayOf("Hot Coffee", "Cold Coffee", "Baked Items")



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppSelectionViewHolder {
        val binding = AppSelectionViewHolderBinding.inflate(LayoutInflater.from(parent.context)
            , parent, false)

        return AppSelectionViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return orders.size
    }

    override fun onBindViewHolder(holder: AppSelectionViewHolder, position: Int) {
        holder.binding.itemNumber.text = (position + 1).toString()
        holder.binding.itemString.text = orders[position].name
    }

    fun ordersUpdated() {
        notifyItemInserted(orders.size-1)
    }
}