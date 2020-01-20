package com.lhh.jetpackdemo.utils

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import com.lhh.jetpackdemo.db.ShoeRepository
import com.lhh.jetpackdemo.model.ShoeModel

class ShoeModelFactory(
    private val repository: ShoeRepository
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShoeModel(repository) as T
    }
}