package com.example.jectpack.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.example.jectpack.db.data.Shoe
import com.joe.jetpackdemo.db.repository.ShoeRepository

class ShoeModel constructor(shoeRepository: ShoeRepository) : ViewModel() {

    companion object {
        private const val ALL = "所有"
    }

    private val brand = MutableLiveData<String>().apply {
        value = ALL
    }

    //鞋子集合的观察类
    val shoes: LiveData<List<Shoe>> = brand.switchMap {
        if (it == ALL) {
            shoeRepository.getAllShoes()
        } else {
            shoeRepository.getShoesByBrand(it)
        }
    }
}