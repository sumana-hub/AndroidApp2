package com.trios2024evsd.androidapp2.ui.detail.ui.detail

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import com.trios2024evsd.androidapp2.ui.detail.R
import com.trios2024evsd.androidapp2.ui.detail.R.Companion.layout

private val Any.order_detail_fragment: Any
    get() {}

class OrderDetailFragment : Fragment() {

    companion object {
        fun newInstance() = OrderDetailFragment()
    }

    private lateinit var viewModel: OrderDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel =
            ViewModelProvider(requireActivity()).get(OrderDetailViewModel::class.java)
            return inflater.inflate(layout.order_detail_fragment, container, false)
    }

}