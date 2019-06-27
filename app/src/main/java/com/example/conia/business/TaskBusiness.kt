package com.example.conia.business

import android.content.Context
import com.example.conia.constants.TaskConstants
import com.example.conia.entities.TaskEntity
import com.example.conia.repository.TaskRepository
import com.example.conia.util.SecurityPreferences

class TaskBusiness(context: Context) {

    private val mTaskRepository: TaskRepository = TaskRepository.getInstance(context)
    private val mSecurityPreferences: SecurityPreferences = SecurityPreferences(context)

    fun getList(taskFilter: Int): MutableList<TaskEntity> {
        val userId = mSecurityPreferences.getStoredString(TaskConstants.KEY.USER_ID).toInt()
        return mTaskRepository.getList(userId, taskFilter)
    }

    fun insert(task: TaskEntity) {
        try {
            with(mTaskRepository) { insert(task) }
        } catch (e: Exception) {
            throw e
        }
    }

    fun get(id: Int) = mTaskRepository.get(id)

    fun update(task: TaskEntity) {
        try {
            mTaskRepository.update(task)
        } catch (e: Exception) {
            throw e
        }
    }

    fun delete(taskId: Int) {
        try {
            mTaskRepository.delete(taskId)
        } catch (e: Exception) {
            throw e
        }
    }

    fun complete(taskId: Int, complete: Boolean){
        val task = mTaskRepository.get(taskId)
        if(task != null){
            task.complete = complete
            mTaskRepository.update(task)
        }
    }

}