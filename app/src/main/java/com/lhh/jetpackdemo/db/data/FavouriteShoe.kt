package com.lhh.jetpackdemo.db.data

import androidx.room.*
import java.util.*

@Entity(tableName = "fav_shoe",foreignKeys = [ForeignKey(entity = Shoe::class,parentColumns = ["id"],childColumns = ["shoe_id"]),
ForeignKey(entity = User::class,parentColumns = ["id"],childColumns = ["user_id"])
],indices = [Index("shoe_id")])

data  class FavouriteShoe (
    @ColumnInfo(name = "shoe_id")
    val shoe_id: Long,
    @ColumnInfo(name = "user_id")
    val user_id: Long,
    @ColumnInfo(name = "fav_date")
    val date: Date
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long=0
}