package com.lhh.jetpackdemo.db.data

import androidx.room.*

@Entity(tableName = "user_table")
data class User(
    @ColumnInfo(name = "user_name")
    val name: String,
    @ColumnInfo(name = "user_accout")
    val accout: String,
    @ColumnInfo(name = "pwd")
    val pwd: String,
    @Ignore val state: Int,//状态只是临时用，所以不需要存储在数据库中
    @Embedded val address: Address


) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long = 0
}