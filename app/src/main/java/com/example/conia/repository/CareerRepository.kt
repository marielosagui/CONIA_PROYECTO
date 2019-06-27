package com.example.conia.repository

import android.content.Context
import android.database.Cursor
import com.example.conia.constants.DatabaseConstants
import com.example.conia.entities.careerEntity

class CareerRepository private constructor(context: Context){

    private var mTaskDatabaseHelper: TaskDatabaseHelper = TaskDatabaseHelper(context)

    companion object {
        fun getInstance(context: Context): CareerRepository{
            if(INSTANCE == null){
                INSTANCE = CareerRepository(context)
            }

            return INSTANCE as CareerRepository
        }

        private var INSTANCE: CareerRepository? = null
    }

    fun getList(): MutableList<careerEntity>{
        val list = mutableListOf<careerEntity>()

        try{
            val cursor: Cursor
            val db = mTaskDatabaseHelper.readableDatabase

            cursor = db.rawQuery("SELECT * FROM ${DatabaseConstants.CAREER.TABLE_NAME}", null)
            if(cursor.count > 0){
                //cursor.moveToFirst()
                while (cursor.moveToNext()){
                    val id = cursor.getInt(cursor.getColumnIndex(DatabaseConstants.CAREER.COLUMNS.ID))
                    val description = cursor.getString(cursor.getColumnIndex(DatabaseConstants.CAREER.COLUMNS.DESCRIPTION))

                    list.add(careerEntity(id, description))
                }
            }
            cursor.close()

        } catch (e: Exception){
            return list
        }

        return list
    }
}