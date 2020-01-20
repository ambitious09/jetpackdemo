package com.lhh.jetpackdemo.utils

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.lhh.jetpackdemo.db.RepositoryProvider
import com.lhh.jetpackdemo.db.data.Shoe
import kotlinx.coroutines.coroutineScope
import java.lang.Exception

class ShoeWork(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {
    private val TAG by lazy {
        ShoeWork::class.java.simpleName
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
       }catch (e: Exception){
           Result.failure()

       }
    }
}