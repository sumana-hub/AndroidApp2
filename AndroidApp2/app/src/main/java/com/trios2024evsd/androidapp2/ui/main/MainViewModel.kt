package com.trios2024evsd.androidapp2.ui.main

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import com.trios2024evsd.androidapp2.models.OrderList

// 1
class MainViewModel(private val sharedPreferences: SharedPreferences) : ViewModel() {

    // 2
    lateinit var onOrderAdded: (() -> Unit)

    // 3
    val orders: MutableList<OrderList> by lazy {
        retrieveOrders()
    }

    // 4
    private fun retrieveOrders(): MutableList<OrderList> {

        val sharedPreferencesContents = sharedPreferences.all
        val orderLists = ArrayList<OrderList>()

        for (orderList in sharedPreferencesContents) {
            val itemsHashSet = ArrayList(orderList.value as HashSet<String>)
            val order = OrderList(orderList.key, itemsHashSet)
            orderLists.add(order)
        }

        return orderLists
    }

    // 5
    fun saveList(order: OrderList) {
        sharedPreferences.edit().putStringSet(order.name, order.orders.toHashSet()).apply()
        orders.add(order)
        onOrderAdded.invoke()
    }
}
