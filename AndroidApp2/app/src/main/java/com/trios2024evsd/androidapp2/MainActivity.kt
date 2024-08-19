package com.trios2024evsd.androidapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.trios2024evsd.androidapp2.databinding.ActivityMainBinding
import com.trios2024evsd.androidapp2.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
        }
        builder.create().show()
    }
}