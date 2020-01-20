package com.lhh.jetpackdemo.utils

import android.content.Context
import com.lhh.jetpackdemo.db.RepositoryProvider
import com.lhh.jetpackdemo.db.ShoeRepository

object CustomViewModelProvider {


    fun providerShoeModel(context: Context):ShoeModelFactory{
        val repository: ShoeRepository = RepositoryProvider.providerShoeRepository(context)
        return ShoeModelFactory(repository)
    }
}