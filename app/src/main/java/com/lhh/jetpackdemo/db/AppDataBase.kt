package com.lhh.jetpackdemo.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.lhh.jetpackdemo.db.dao.ShoeDao
import com.lhh.jetpackdemo.db.data.Shoe
import com.lhh.jetpackdemo.utils.ShoeWork

@Database(entities = [Shoe::class],version = 1,exportSchema = false)
abstract class AppDataBase:RoomDatabase() {

    abstract fun shoeDao(): ShoeDao

    companion object{
        @Volatile
        private var instance: AppDataBase?=null

        fun getInstance(context: Context): AppDataBase{
            return instance?: synchronized(this){
                instance?:buildDataBase(context).also{
                instance=it
            }
            }
        }

        private  fun buildDataBase(context: Context): AppDataBase{
            return  Room.databaseBuilder(context,AppDataBase::class.java,"jetPackDemo-database")
                .addCallback(object :Callback(){
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        //读取鞋的集合
                        val request= OneTimeWorkRequestBuilder<ShoeWork>().build()
                        WorkManager.getInstance(context).enqueue(request)
                    }
                })
                .build()

        }




    }

}