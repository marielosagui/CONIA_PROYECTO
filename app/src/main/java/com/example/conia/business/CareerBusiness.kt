package com.example.conia.business

import android.content.Context
import com.example.conia.entities.careerEntity
import com.example.conia.repository.CareerRepository

class CareerBusiness(context: Context) {

    private val mCareerRepository: CareerRepository = CareerRepository.getInstance(context)

    fun getList(): MutableList<careerEntity> = mCareerRepository.getList()
}