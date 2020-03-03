package com.lhh.jetpackdemo.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.lhh.jetpackdemo.db.data.User

@Dao
interface UserDao {
    @Query("SELECT * FROM user_table WHERE user_accout = :account AND pwd = :pwd")
    fun login(account:String,pwd:String): LiveData<User?>

    @Query("SELECT * FROM user_table WHERE id=:id")
    fun findUserById(id:Long): LiveData<User>

    @Query("SELECT * FROM user_table")
    fun getAllUsers():List<User>


    @Insert
    fun insertUser(user:User):Long

    @Delete
    fun deleteUser(user: User)

}