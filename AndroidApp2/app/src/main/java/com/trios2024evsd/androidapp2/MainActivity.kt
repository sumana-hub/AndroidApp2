package com.trios2024evsd.androidapp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.preference.PreferenceManager
import com.trios2024evsd.androidapp2.databinding.ActivityMainBinding
import com.trios2024evsd.androidapp2.models.OrderList
import com.trios2024evsd.androidapp2.ui.detail.OrderDetailActivity
import com.trios2024evsd.androidapp2.ui.main.MainFragment
import com.trios2024evsd.androidapp2.ui.main.MainViewModel
import com.trios2024evsd.androidapp2.ui.main.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel =ViewModelProvider(this,
            MainViewModelFactory(PreferenceManager.getDefaultSharedPreferences(this))
        )
            .get(MainViewModel::class.java)


        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }

        binding.fabButton.setOnClickListener {
            showCreateOrderDialog()
        }
    }

    private fun showCreateOrderDialog() {
        val dialogTitle = getString(R.string.name_of_order)
        val positiveButtonTitle = getString(R.string.create_order)

        val builder = AlertDialog.Builder(this)
        val orderTitleEditText = EditText(this)
        orderTitleEditText.inputType = InputType.TYPE_CLASS_TEXT

        builder.setTitle(dialogTitle)
        builder.setView(orderTitleEditText)

        builder.setPositiveButton(positiveButtonTitle) {
            dialog, _ -> dialog.dismiss()
            val orderList = OrderList(orderTitleEditText.text.toString())
            viewModel.saveList(orderList)
            showOrderDetail(orderList)
        }
        builder.create().show()
    }
    private fun showOrderDetail (order: OrderList) {
        val orderDetailIntent = Intent(this, OrderDetailActivity::class.java)
        orderDetailIntent.putExtra(INTENT_ORDER_KEY, order)
        startActivity(orderDetailIntent)
    }

    companion object {
        const val INTENT_ORDER_KEY = "order"
    }


}