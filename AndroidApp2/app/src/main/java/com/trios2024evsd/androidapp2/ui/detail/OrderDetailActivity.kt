package com.trios2024evsd.androidapp2.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.trios2024evsd.androidapp2.MainActivity
import com.trios2024evsd.androidapp2.ui.detail.R.Companion.layout
import com.trios2024evsd.androidapp2.ui.detail.ui.detail.OrderDetailFragment

private val Any.container: Int
    get() {}

class OrderDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.order_detail_activity)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, OrderDetailFragment.newInstance())
                .commitNow()
        }
    }
}