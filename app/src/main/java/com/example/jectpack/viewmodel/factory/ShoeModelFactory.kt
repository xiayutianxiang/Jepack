package com.example.jectpack.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.jectpack.viewmodel.ShoeModel
import com.joe.jetpackdemo.db.repository.ShoeRepository


/**
 * 获取ViewModel
 *
 * 无构造参数获取：
    构造函数没有参数的情况下，获取ShoeModel很简单，ViewModelProviders.of(this).get(ShoeModel::class.java)这样就可以返回一个我们需要的ShoeModel了。

有构造参数获取
不过，上面的ShoeModel中我们在构造函数中需要一个ShoeRepository参数，这种情况下我们需要自定义实现Factory：
 */
class ShoeModelFactory (private val shoeRepository: ShoeRepository):ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShoeModel(shoeRepository) as T
    }
}