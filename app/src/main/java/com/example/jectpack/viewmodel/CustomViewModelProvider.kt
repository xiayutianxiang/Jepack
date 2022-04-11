package com.example.jectpack.viewmodel

import android.content.Context
import com.example.jectpack.db.RepositoryProvider
import com.example.jectpack.viewmodel.factory.ShoeModelFactory
import com.joe.jetpackdemo.db.repository.ShoeRepository

object CustomViewModelProvider {


    //获取shoeModel
    open fun providerShoeModel(context: Context):ShoeModelFactory{
        val repository:ShoeRepository = RepositoryProvider.providerShoeRepository(context)

        return ShoeModelFactory(repository)
    }
}