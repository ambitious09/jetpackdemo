package com.lhh.jetpackdemo.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.lhh.jetpackdemo.db.data.Shoe


@Dao
interface ShoeDao {

    @Query("SELECT * FROM shoe")
    fun getAllShoes(): LiveData<List<Shoe>>

    @Query("SELECT * FROM shoe WHERE id=:id")
    fun findShoeById(id:Long): LiveData<Shoe>

    /**
     * 通过品牌查询鞋子
     */
    @Query("SELECT * FROM shoe WHERE shoe_brand=:brand")
    fun findShoeByBrand(brand: String): LiveData<List<Shoe>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertShoe(shoe: Shoe)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertShoes(shoes: List<Shoe>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateShoe(shoe:Shoe)




}