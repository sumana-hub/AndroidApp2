package com.trios2024evsd.androidapp2.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.trios2024evsd.androidapp2.databinding.AppSelectionViewHolderBinding

class AppSelectionRecyclerViewAdapter:
RecyclerView.Adapter<AppSelectionViewHolder>(){

    val appTitles = arrayOf("Shopping List", "Chores", "Android Tutorials")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppSelectionViewHolder {
        val binding = AppSelectionViewHolderBinding.inflate(LayoutInflater.from(parent.context)
            , parent, false)

        return AppSelectionViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return appTitles.size
    }

    override fun onBindViewHolder(holder: AppSelectionViewHolder, position: Int) {
        holder.binding.itemNumber.text = (position + 1).toString()
        holder.binding.itemString.text = appTitles[position]
    }
}