package com.example.jectpack.ui.fragment.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.jectpack.R
import com.example.jectpack.databinding.FragmentShoeBinding
import com.example.jectpack.ui.adapter.ShoeAdapter
import com.example.jectpack.viewmodel.CustomViewModelProvider
import com.example.jectpack.viewmodel.ShoeModel

class ShoeFragment : Fragment() {

    private lateinit var viewBinding: FragmentShoeBinding

    private val viewModel: ShoeModel by viewModels {
        CustomViewModelProvider.providerShoeModel(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        viewBinding = FragmentShoeBinding.inflate(layoutInflater)
        ViewModelProvider(this).get(ShoeModel::class.java)
        val adapter = ShoeAdapter()
        viewBinding.recycler.adapter = adapter
        onSubscribeUi(adapter)
        return viewBinding.root
    }

    /**
     * 鞋子数据更新的通知
     */
    private fun onSubscribeUi(adapter: ShoeAdapter) {
        viewModel.shoes.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                adapter.submitList(it)
            }
        })
    }
}