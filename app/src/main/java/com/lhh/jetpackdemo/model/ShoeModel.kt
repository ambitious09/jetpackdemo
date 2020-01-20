package com.lhh.jetpackdemo.model

import androidx.lifecycle.*
import com.lhh.jetpackdemo.db.ShoeRepository
import com.lhh.jetpackdemo.db.data.Shoe

class ShoeModel  constructor(shoeRepository: ShoeRepository): ViewModel(){

    private val brand=MutableLiveData<String>().apply {
        value= ALL
    }


    // 鞋子集合的观察类
    val shoes: LiveData<List<Shoe>> = brand.switchMap {
        // Room数据库查询，只要知道返回的是LiveData<List<Shoe>>即可
//        when(it){
//            ALL->{ shoeRepository.getAllShoes()}
//            "insert"->shoeRepository.insertShoe(Shoe())
//            else -> shoeRepository.getShoesByBrand(it)
//        }
        if (it == ALL) {
            shoeRepository.getAllShoes()
        } else {
            shoeRepository.getShoesByBrand(it)
        }
    }

    fun setBrand(brand:String){
        this.brand.value = brand

        this.brand.map {

        }
    }



    fun clearBrand(){
        this.brand.value = ALL
    }



    companion object {
        private const val ALL = "所有"
    }

}