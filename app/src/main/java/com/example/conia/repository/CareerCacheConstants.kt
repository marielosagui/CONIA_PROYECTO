package com.example.conia.repository

import com.example.conia.entities.careerEntity

class CareerCacheConstants private constructor(){

    companion object {

        fun setCache(list: List<careerEntity>){
            for(item in list){
                mCareerCache.put(item.id, item.description)
            }

        }

        fun getCareerDescription(id: Int): String{
            if(mCareerCache[id] == null){
                return ""
            }
            return mCareerCache[id].toString()
        }

        private val mCareerCache = hashMapOf<Int, String>()
    }
}