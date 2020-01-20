package com.lhh.jetpackdemo.db

import android.content.Context

object RepositoryProvider {



    /**
     * 得到鞋的本地仓库
     */
    fun providerShoeRepository(context: Context): ShoeRepository {
        return ShoeRepository.getInstance(AppDataBase.getInstance(context).shoeDao())
    }

}