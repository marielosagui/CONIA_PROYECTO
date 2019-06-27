package com.example.conia.business

import android.content.Context
import com.example.conia.R
import com.example.conia.constants.DatabaseConstants
import com.example.conia.constants.TaskConstants
import com.example.conia.entities.UserEntity
import com.example.conia.repository.UserRepository
import com.example.conia.util.SecurityPreferences
import com.example.conia.util.ValidationException

class UserBusiness(var context: Context) {
    private val mUserRepository: UserRepository = UserRepository.getInstance(context)
    private val mSecurityPreferences: SecurityPreferences = SecurityPreferences(context)

    fun login(email: String, password: String): Boolean{
        val user: UserEntity? = mUserRepository.get(email, password)

        return if(user != null){
            mSecurityPreferences.storeString(TaskConstants.KEY.USER_ID, user.id.toString())
            mSecurityPreferences.storeString(TaskConstants.KEY.USER_NAME, user.name)
            mSecurityPreferences.storeString(TaskConstants.KEY.USER_EMAIL, user.email)

            true
        } else {
            false
        }
    }

    fun insert(name: String, email: String, password: String){
        try {
            if(name == "" || email == "" || password == ""){
                throw ValidationException(context.getString(R.string.informe_campos))
            }

            if(mUserRepository.isEmailExistent(email)){
                throw ValidationException(context.getString(R.string.email_existente))
            }
                
            val userId = mUserRepository.insert(name, email, password)

            //saving data
            mSecurityPreferences.storeString(TaskConstants.KEY.USER_ID, userId.toString())
            mSecurityPreferences.storeString(TaskConstants.KEY.USER_NAME, name)
            mSecurityPreferences.storeString(TaskConstants.KEY.USER_EMAIL, email)

            
        } catch (e: Exception){
            throw e
        }

    }
}