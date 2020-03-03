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

    @Query("SELECT * from shoe where shoe_name like :name order by shoe_brand asc")
    fun findshoesByname( name: String): List<Shoe>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertShoe(shoe: Shoe)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertShoes(shoes: List<Shoe>)

    @Delete
    fun deleteshoe(shoe: Shoe)

    @Delete
    fun deleteshoes(shoes: List<Shoe>)


    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateShoe(shoe:Shoe)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateShoe(shoes:List<Shoe>)

    //复合查询

    @Query("select shoe.id,shoe.shoe_brand,shoe.shoe_price,shoe.shoe_name,shoe.shoe_imgUrl,shoe.shoe_description "+
    "from shoe"+
            "INNER JOIN fav_shoe ON fav_shoe.shoe_id = shoe.id " +
            "WHERE fav_shoe.user_id = :userId"
    )
    fun selectUserByid(userid: Long): LiveData<List<Shoe>>




}
