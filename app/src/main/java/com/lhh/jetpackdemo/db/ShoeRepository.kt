package com.lhh.jetpackdemo.db

import com.lhh.jetpackdemo.db.dao.ShoeDao
import com.lhh.jetpackdemo.db.data.Shoe

class ShoeRepository private  constructor(val shoe: ShoeDao){

    fun getAllShoes() = shoe.getAllShoes()

    /**
     * 通过品牌查询鞋子
     */
    fun getShoesByBrand(brand:String) = shoe.findShoeByBrand(brand)

    /**
     * 插入鞋子的集合
     */
    fun insertShoes(shoes: List<Shoe>) = shoe.insertShoes(shoes)   /**
     * 插入鞋子的集合
     */
    fun insertShoe(shoes: Shoe) = shoe.insertShoe(shoes)

    companion object {
        @Volatile
        private var instance: ShoeRepository? = null

        fun getInstance(shoeDao: ShoeDao): ShoeRepository =
            instance ?: synchronized(this) {
                instance
                    ?: ShoeRepository(shoeDao).also {
                        instance = it
                    }
            }

    }

}