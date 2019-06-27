package com.example.conia.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.conia.constants.DatabaseConstants

class TaskDatabaseHelper(context: Context) :SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private val DATABASE_VERSION: Int = 1
        private val DATABASE_NAME: String = "conia.db"
    }


    private val createTableUser = """ CREATE TABLE ${DatabaseConstants.USER.TABLE_NAME}(
        ${DatabaseConstants.USER.COLUMNS.ID} INTEGER PRIMARY KEY AUTOINCREMENT,
        ${DatabaseConstants.USER.COLUMNS.NAME} TEXT,
        ${DatabaseConstants.USER.COLUMNS.EMAIL} TEXT,
        ${DatabaseConstants.USER.COLUMNS.PASSWORD} TEXT

    );"""

    private val createTablePriority = """ CREATE TABLE ${DatabaseConstants.CAREER.TABLE_NAME}(
        ${DatabaseConstants.CAREER.COLUMNS.ID} INTEGER PRIMARY KEY,
        ${DatabaseConstants.CAREER.COLUMNS.DESCRIPTION} TEXT

    );"""

    private val createTableTask = """ CREATE TABLE ${DatabaseConstants.TASK.TABLE_NAME}(
        ${DatabaseConstants.TASK.COLUMNS.ID} INTEGER PRIMARY KEY AUTOINCREMENT,
        ${DatabaseConstants.TASK.COLUMNS.CAREERID} INTEGER,
        ${DatabaseConstants.TASK.COLUMNS.USERID} INTEGER,
        ${DatabaseConstants.TASK.COLUMNS.DESCRIPTION} TEXT,
        ${DatabaseConstants.TASK.COLUMNS.COMPLETE} INTEGER,
        ${DatabaseConstants.TASK.COLUMNS.DUEDATE} TEXT,
        ${DatabaseConstants.TASK.COLUMNS.AULA} TEXT
        

    );"""

    private val insertCareers = """INSERT INTO ${DatabaseConstants.CAREER.TABLE_NAME}
        VALUES (1, 'Arquitectura'),(2, 'Industrial'),(3, 'Quimica'),(4, 'Informatica'),(5, 'Civil'),(6, 'Mecanica'),(7, 'Electrica');
        """

    private val deleteTableUser = "drop table if exists ${DatabaseConstants.USER.TABLE_NAME}"
    private val deleteTablePriority = "drop table if exists ${DatabaseConstants.CAREER.TABLE_NAME}"
    private val deleteTableTask = "drop table if exists ${DatabaseConstants.TASK.TABLE_NAME}"



    override fun onCreate(sqlLite: SQLiteDatabase) {
        sqlLite.execSQL(createTableUser)
        sqlLite.execSQL(createTablePriority)
        sqlLite.execSQL(createTableTask)

        sqlLite.execSQL(insertCareers)
    }

    override fun onUpgrade(sqlLite: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        sqlLite.execSQL(deleteTableUser)
        sqlLite.execSQL(deleteTablePriority)
        sqlLite.execSQL(deleteTableTask)

        sqlLite.execSQL(createTableUser)
        sqlLite.execSQL(createTablePriority)
        sqlLite.execSQL(createTableTask)



    }


}