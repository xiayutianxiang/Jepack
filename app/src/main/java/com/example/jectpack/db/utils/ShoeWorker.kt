package com.example.jectpack.db.utils

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.ListenableWorker
import androidx.work.WorkerParameters
import com.example.jectpack.db.RepositoryProvider
import com.example.jectpack.db.data.Shoe
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import kotlinx.coroutines.coroutineScope
import java.lang.Exception

class ShoeWorker(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {

    private val TAG by lazy {
        ShoeWorker::class.java.simpleName
    }

    override suspend fun doWork(): Result = coroutineScope {
        try {
            applicationContext.assets.open("shoes.json").use {
              JsonReader(it.reader()).use {
                    val shoeType = object : TypeToken<List<Shoe>>() {}.type
                    val shoeList: List<Shoe> = Gson().fromJson(it, shoeType)

                    val shoeDao = RepositoryProvider.providerShoeRepository(applicationContext)
                    shoeDao.insertShoes(shoeList)
                    Result.success()
                }

            }
        } catch (ex: Exception) {
            Log.e(TAG, "Error seeding database", ex)
            Result.failure()
        }

    }


}